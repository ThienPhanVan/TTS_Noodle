package com.cg.services.impl;


import com.cg.dto.order.*;
import com.cg.dto.payment.PaymentCustomerResult;
import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.exceptions.DataInputException;
import com.cg.mapper.OrderMapper;
import com.cg.exceptions.NotEnoughQuantityException;
import com.cg.exceptions.NotFoundException;
import com.cg.mapper.PaymentMapper;
import com.cg.repositories.*;
import com.cg.repositories.model.*;

import com.cg.dto.order.OrderItemParam;
import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
import com.cg.repositories.ItemRepository;
import com.cg.repositories.OrderItemRepository;
import com.cg.repositories.OrderRepository;
import com.cg.repositories.UserRepository;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private PaymentPurchaseRepository paymentPurchaseRepository;


    @Autowired
    private PaymentMapper paymentMapper;



    @Autowired
    private PaymentCustomerRepository paymentCustomerRepository;

    @Override
    public List<OrderResult> findAll() {
        return orderRepository.findAll().stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }


    @Override
    public OrderResult findById(Long id) {
        return orderMapper.toDTO(orderRepository.findById(id).get());
    }


    @Override
    @Transactional
    public OrderResult createOrderExport(OrderParam orderParam) {
        //order Item
        Long userId = orderParam.getUserId();
        if (userId != null && !userRepository.existsById(userId))
            throw new NotFoundException("Id khach hang khong hop le");
        //Transient
        Order order = orderMapper.toModel(orderParam);
        if (userId != null)
        order.setUserId(userId);
        order.setCreatedAt(Instant.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setCreatedBy(1L);
        order.setOrderType(OrderType.CUSTOMER);
        order.setGrandTotal(new BigDecimal(0));
        order = orderRepository.save(order);

        BigDecimal grandTotal = BigDecimal.valueOf(0);
        for (OrderItemParam itemParam : orderParam.getOrderItems()) {
            //kiem tra product ton tai
            //lay toan item theo productId
            long productId = itemParam.getProductId();
            Optional<Product> productOptional = productRepository.findById(productId);
            if (!productOptional.isPresent()) {
                throw new NotFoundException("Không Tìm Thấy productId " + itemParam.getProductId());
            }

            BigDecimal price = productOptional.get().getPrice();
            // lấy số lượng customer order
            int quantityCustomer = itemParam.getQuantity();
            //tổng giá sản phẩm = giá sản phẩm * số lượng sản phẩm khách hàng order
            grandTotal = price.multiply(new BigDecimal(quantityCustomer));
            order.setGrandTotal(grandTotal);

            // lay toan item theo productId
            List<Item> items = itemRepository.findAllByProductIdAndAvailableGreaterThanOrderByCreatedAt(productId, 0);
            long totalAvailable = items.stream().mapToInt(Item::getAvailable).sum();
            // nếu tổng sản phẩm nhỏ hơn số lượng order thì gửi thông báo số lượng k đủ
            if (totalAvailable < itemParam.getQuantity()) {
                throw new NotEnoughQuantityException("Không đủ số lượng, vui lòng kiểm tra số lượng!");
            }

            for (Item item : items) {
                if (quantityCustomer == 0) {
                    break;
                }
                int available = item.getAvailable();
                int orderItemSold;
                if (quantityCustomer >= available) {
                    quantityCustomer = quantityCustomer - available;
                    item.setAvailable(0);
                    orderItemSold = available;
                    int itemSold = item.getSold() + available;
                    item.setSold(itemSold);
                } else {
                    available = available - quantityCustomer;
                    item.setAvailable(available);
                    orderItemSold = quantityCustomer;
                    int itemSold = item.getSold() + quantityCustomer;
                    item.setSold(itemSold);
                    quantityCustomer = 0;
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(orderItemSold);
                orderItem.setProductId(item.getProductId());
                orderItem.setItemId(item.getId());
                orderItem.setOrderId(order.getId());
                orderItem.setPrice(item.getPrice());
                orderItemRepository.save(orderItem);
            }
        }
        PaymentCustomer paymentCustomer = new PaymentCustomer();

        BigDecimal paymentInput = orderParam.getPaid();
        BigDecimal newTotal = new BigDecimal(0);
        BigDecimal totalAmount = grandTotal.subtract(paymentInput);
        paymentCustomer.setOrderId(order.getId());

        if (userId == null){
            if(paymentInput.compareTo(newTotal) == 0) {
                order.setOrderStatus(OrderStatus.COMPLETED);
                paymentCustomer.setPaid(orderParam.getPaid());
                paymentCustomerRepository.save(paymentCustomer);
                return orderMapper.toDTO(order);
            }else {
                throw new NotFoundException("Số tiền nhập vào không đủ, vui lòng nhập đủ số tiền!!!");
            }
        }else {
            if (paymentInput.compareTo(newTotal) == 0){
                paymentCustomer.setUserId(userId);
                order.setOrderStatus(OrderStatus.COMPLETED);
                paymentCustomer.setPaid(totalAmount);
                paymentCustomerRepository.save(paymentCustomer);
                return orderMapper.toDTO(order);
            }else {
                paymentCustomer.setUserId(userId);
                paymentCustomer.setPaid(orderParam.getPaid());
                paymentCustomerRepository.save(paymentCustomer);
                return orderMapper.toDTO(order);
            }

        }
    }

    @Override
    public List<OrderListPurchase> findAllByOrderTypePurchaseList() {
        return orderRepository.findAllByOrderType(OrderType.PURCHASE)
                .stream()
                .map(order -> orderMapper.toDTOList(order))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderListPurchase> findAllByOrderTypeCustomerList() {
        return orderRepository.findAllByOrderType(OrderType.CUSTOMER)
                .stream()
                .map(order -> orderMapper.toDTOList(order))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResult> findAllByOrderTypePurchase() {
        return orderRepository.findAllByOrderType(OrderType.PURCHASE).stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderResult> findAllByOrderTypeCustomer() {
        return orderRepository.findAllByOrderType(OrderType.CUSTOMER)
                .stream().map(order -> orderMapper.toDTO(order))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<OrderResult> findAllByCreatedAtAndOrderType(Instant data, OrderType orderType) {
//        return orderRepository.findAllByCreatedAtAndOrderType(data, OrderType.CUSTOMER)
//                .stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
//    }

    @Override
    public List<OrderResult> findAllByOrderStatusPending() {
        return orderRepository.findAllByOrderStatus(OrderStatus.PENDING).stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderResult> findAllByOrderStatusComplete() {
        return orderRepository.findAllByOrderStatus(OrderStatus.COMPLETED).stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderResult> findAllByOrderStatusCancel() {
        return orderRepository.findAllByOrderStatus(OrderStatus.CANCELLED).stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public OrderResult createOrderImport(OrderPurchase orderPurchase) {

        Optional<User> userOptional = userRepository.findById(orderPurchase.getUserId());

        if (!userOptional.isPresent()) {
            throw new NotFoundException("Không tìm thấy nhà cung cấp!");
        }

        LocalDateTime localDateTime = LocalDateTime.parse(orderPurchase.getCreatedAt());

        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

        Long userId = userOptional.get().getId();

        List<OrderItemPurchase> orderItemPurchaseList = orderPurchase.getOrderItemPurchases();

        BigDecimal totalAmount = BigDecimal.valueOf(0);

        Order newOrder = new Order();

        for (OrderItemPurchase orderItemPurchase : orderItemPurchaseList) {

            Long productId = orderItemPurchase.getProductId();

            Optional<Product> productOptional = productRepository.findById(productId);

            if (!productOptional.isPresent()) {
                throw new NotFoundException("Không tìm thấy sản phẩm!");
            }

            BigDecimal price = orderItemPurchase.getPrice();

            int quantity = orderItemPurchase.getQuantity();

            totalAmount = totalAmount.add(price.multiply(new BigDecimal(quantity)));

            newOrder.setGrandTotal(totalAmount);
            if (totalAmount.compareTo(orderPurchase.getPaid()) == 0){
                newOrder.setOrderStatus(OrderStatus.COMPLETED);
            } else {
                newOrder.setOrderStatus(OrderStatus.PENDING);
            }

        }

        newOrder.setCreatedBy(1L);
        newOrder.setAddress(userOptional.get().getAddress());
        newOrder.setUserId(userId);
        newOrder.setOrderType(OrderType.PURCHASE);
        newOrder.setCreatedAt(instant);

        orderRepository.save(newOrder);

        PaymentPurchase newPaymentPurchase = new PaymentPurchase();

        newPaymentPurchase.setOrderId(newOrder.getId());
        newPaymentPurchase.setPaid(orderPurchase.getPaid());
        newPaymentPurchase.setUserId(userId);
        paymentPurchaseRepository.save(newPaymentPurchase);


        for (OrderItemPurchase orderItemPurchase : orderItemPurchaseList) {
            BigDecimal price = orderItemPurchase.getPrice();
            int quantity = orderItemPurchase.getQuantity();
            Long productId = orderItemPurchase.getProductId();

            Item newItem = new Item();

            newItem.setPrice(orderItemPurchase.getPrice());
            newItem.setQuantity(quantity);
            newItem.setAvailable(quantity);
            newItem.setSold(0);
            newItem.setDefective(0);
            newItem.setCreatedAt(instant);
            newItem.setCreatedBy(1L);
            newItem.setUserId(userId);
            newItem.setOrderId(newOrder.getId());
            newItem.setProductId(productId);

            itemRepository.save(newItem);

            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setPrice(price);
            newOrderItem.setQuantity(quantity);
            newOrderItem.setOrderId(newOrder.getId());
            newOrderItem.setProductId(productId);
            newOrderItem.setItemId(newItem.getId());

            orderItemRepository.save(newOrderItem);

        }
        return orderMapper.toDTO(newOrder);
    }


    @Override
    public List<OrderListPurchase> searchOrderBySupplierOOrCreatedAt(String keyword) {
        return null;
//        return orderRepository.searchOrderBySupplierOOrCreatedAt(keyword)
//                .stream()
//                .map(order -> orderMapper.toDTOList(order))
//                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResult> findAllByUserId(Long userId) {
        return orderRepository.findOrderByUserId(userId).stream()
                .map(order -> orderMapper.toDTO(order))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResultChart> findOrderSevenDay() {
        return orderRepository.findOrderSevenDay();
    }

    @Override
    public List<OrderPurchaseDTO> findAllOrderPurchase() {

        return orderRepository.findAllOrderPurchase();
    }

    @Override
    public List<OrderResult> getAllOrderByRole() {
        return orderRepository.getAllOrderByRole().stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderPurchaseDTO> findAllOrderPurchaseStatusPending() {
        return orderRepository.findAllOrderPurchaseStatusPending();
    }

    @Override
    public List<OrderPurchaseDTO> findAllOrderPurchaseStatusCancel() {
        return orderRepository.findAllOrderPurchaseStatusCancel();
    }

    @Override
    public List<OrderPurchaseDTO> findAllOrderPurchaseStatusComplete() {
        return orderRepository.findAllOrderPurchaseStatusComplete();
    }

    @Override
    public List<OrderPurchaseDTO> findOrderByFullNameContainsAndOrderType(String keySearch) {
        List<OrderPurchaseView> list = orderRepository.findOrderByFullNameContainsAndOrderType(keySearch);

        List<OrderPurchaseDTO> orderPurchaseDTOList = list.stream().map(orderPurchaseView -> {
                    OrderPurchaseDTOImpl orderPurchaseDTOImpl = new OrderPurchaseDTOImpl();
                    orderPurchaseDTOImpl.setFromOrderPurchaseView(orderPurchaseView);
                    return orderPurchaseDTOImpl;
                })
                .collect(Collectors.toList());
//        return orderRepository.findOrderByFullNameContainsAndOrderType(keySearch);
        return orderPurchaseDTOList;
    }

    @Override
    public List<OrderResultDTO> findOrderByFullNameAndAddressContainsAndOrderType(String keySearch) {
        return orderRepository.findOrderByFullNameAndAddressContainsAndOrderType(keySearch);
    }

    public void updateOrderStatus(OrderResult orderResult) {
        Optional<Order> orderPurchase1 = orderRepository.findById(orderResult.getId());
        if (orderPurchase1.isPresent()) {
            throw new DataInputException("Không tìm thấy order");
        }
    }

    @Override
    public BigDecimal chartOneDay() {
        return orderRepository.chartOneDay();
    }

    @Override
    public List<OrderResultChart> findOrderOneMonth() {
        return orderRepository.findOrderOneMonth();
    }

    @Override
    public List<OrderResultDTOS> findAllOrderStatusCompleted() {
        return orderRepository.findAllOrderStatusCompleted();
    }

    @Override
    public List<OrderResultDTOS> findAllOrderStatusPending() {
        return orderRepository.findAllOrderStatusPending();
    }

    @Override
    public OrderResultDTO setStatusOrderPending(Long id) {
//        Optional<Order> orderOptional = orderRepository.findById(orderChangeStatus.getId());
//
//        Order newOrder = orderOptional.get();
//
//        System.out.println(newOrder);
//
//        newOrder.setOrderStatus(orderChangeStatus.getOrderStatus());
//
//        orderRepository.save(newOrder);

        return null;
    }

    @Transactional
    public OrderChangeStatus changeStatus(OrderChangeStatus orderChangeStatus) {

        Optional<Order> orderOptional = orderRepository.findById(orderChangeStatus.getId());

        Order newOrder = orderOptional.get();

        System.out.println(newOrder);

        newOrder.setOrderStatus(orderChangeStatus.getOrderStatus());

        orderRepository.save(newOrder);

        return orderMapper.toDTOOrderStatus(newOrder);

    }

    @Override
    public List<OrderResultDTOS> findAllByOrderView() {
        return orderRepository.findAllByOrderView();
    }

    @Override

    public OrderResultDTOS findAllByOrderViewById(Long id) {
        return orderRepository.findAllByOrderViewById(id);
    }

    @Transactional
    public PaymentPurchaseResult doPaid(OrderPaid orderPaid) {

        Optional<Order> orderOptional = orderRepository.findById(orderPaid.getOrderId());

        BigDecimal grandTotal = orderOptional.get().getGrandTotal();

        Long userId = orderOptional.get().getUserId();

        BigDecimal paid = orderPaid.getPaid();

        List<PaymentPurchase> paymentResultPurchases = paymentPurchaseRepository.findAllByOrderId(orderPaid.getOrderId());

        BigDecimal newAmount = BigDecimal.valueOf(0);

        for(PaymentPurchase paymentPurchase : paymentResultPurchases){
           BigDecimal amount = paymentPurchase.getPaid();

            newAmount = newAmount.add(amount);
        }

        BigDecimal newTotal = newAmount.add(paid);

        PaymentPurchase newPaymentPurchase = new PaymentPurchase();

        if (grandTotal.compareTo(newTotal) == 1){

            newPaymentPurchase.setUserId(userId);
            newPaymentPurchase.setOrderId(orderPaid.getOrderId());
            newPaymentPurchase.setPaid(orderPaid.getPaid());

            paymentPurchaseRepository.save(newPaymentPurchase);

            return paymentMapper.toDTOS(newPaymentPurchase);

        }
        if (grandTotal.compareTo(newTotal) == -1){
            throw new DataInputException("Lỗi hệ thống vui lòng liên hệ quản trị viên!!");
        }
        if (grandTotal.compareTo(newTotal) == 0){

            orderOptional.get().setOrderStatus(OrderStatus.COMPLETED);

            orderRepository.save(orderOptional.get());
            newPaymentPurchase.setUserId(userId);
            newPaymentPurchase.setOrderId(orderPaid.getOrderId());
            newPaymentPurchase.setPaid(orderPaid.getPaid());

            paymentPurchaseRepository.save(newPaymentPurchase);

            return paymentMapper.toDTOS(newPaymentPurchase);

        }
        return paymentMapper.toDTOS(newPaymentPurchase);
    }

    @Transactional
    public PaymentCustomerResult doPaidCustomer(OrderCustomerPaid orderCustomerPaid) {
        Optional<Order> orderOptional = orderRepository.findById(orderCustomerPaid.getOrderId());
        BigDecimal grandTotal = orderOptional.get().getGrandTotal();
        Long userId = orderOptional.get().getUserId();
        BigDecimal paid = orderCustomerPaid.getPaid();
        List<PaymentCustomer> paymentCustomers = paymentCustomerRepository.findAllByOrderId(orderCustomerPaid.getOrderId());
        BigDecimal newAmount = BigDecimal.valueOf(0);
        for (PaymentCustomer paymentCustomer: paymentCustomers){
            BigDecimal amount = paymentCustomer.getPaid();
            newAmount = newAmount.add(amount);
        }
        BigDecimal newTotal = newAmount.add(paid);

        PaymentCustomer newPaymentCustomer = new PaymentCustomer();
        if (grandTotal.compareTo(newTotal) == 1){

            newPaymentCustomer.setUserId(userId);
            newPaymentCustomer.setOrderId(orderCustomerPaid.getOrderId());
            newPaymentCustomer.setPaid(orderCustomerPaid.getPaid());

            paymentCustomerRepository.save(newPaymentCustomer);

            return paymentMapper.toDTO(newPaymentCustomer);

        }
        if (grandTotal.compareTo(newTotal) == -1){
            throw new DataInputException("Lỗi hệ thống vui lòng liên hệ quản trị viên!!");
        }
        if (grandTotal.compareTo(newTotal) == 0){

            orderOptional.get().setOrderStatus(OrderStatus.COMPLETED);

            orderRepository.save(orderOptional.get());
            newPaymentCustomer.setUserId(userId);
            newPaymentCustomer.setOrderId(orderCustomerPaid.getOrderId());
            newPaymentCustomer.setPaid(orderCustomerPaid.getPaid());

            paymentCustomerRepository.save(newPaymentCustomer);

            return paymentMapper.toDTO(newPaymentCustomer);

        }
        return paymentMapper.toDTO(newPaymentCustomer);
    }

    @Override
    public OrderResultPaidDTO findOrderByIdPaidCustomer(Long id) {
        return orderRepository.findOrderByIdPaidCustomer(id);
    }
}