package com.cg.services.impl;


import com.cg.dto.order.*;
import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.OrderMapper;
import com.cg.exceptions.NotEnoughQuantityException;
import com.cg.exceptions.NotFoundException;
import com.cg.repositories.*;
import com.cg.repositories.model.*;

import com.cg.dto.order.OrderItemParam;
import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
import com.cg.mapper.OrderItemMapper;

import com.cg.mapper.UserMapper;
import com.cg.repositories.ItemRepository;
import com.cg.repositories.OrderItemRepository;
import com.cg.repositories.OrderRepository;
import com.cg.repositories.UserRepository;

import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;


    private UserMapper userMapper;


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
//        Transient
        //order Item
        Long userId = orderParam.getUserId();
        if (userId != null) {
            Optional<User> optional = userRepository.findById(userId);
            if (!optional.isPresent())
                throw new NotFoundException("Không Tìm Thấy Id Khách Hàng!");
        }
//            order.setFullName(orderParam.getFullName());
//            order.setPhone(orderParam.getPhone());
////            order.setUserId(orderParam.getUserId());
//            order.setAddress(orderParam.getAddress());
//            order.setCreatedAt(Instant.now());
//            order.setOrderStatus(OrderStatus.PENDING);
//            order.setCreatedBy(2L);
//            order.setOrderType(OrderType.CUSTOMER);
//            order.setGrandTotal(new BigDecimal(0));
//            order = orderRepository.save(order);
//
//            BigDecimal grandTotal = BigDecimal.valueOf(0);

//        } else {
        Order order = orderMapper.toModel(orderParam);
        order.setFullName(orderParam.getFullName());
        order.setPhone(orderParam.getPhone());
        order.setAddress(orderParam.getAddress());
        order.setCreatedAt(Instant.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setCreatedBy(1L);
        order.setOrderType(OrderType.CUSTOMER);
        order.setGrandTotal(new BigDecimal(0));
        order = orderRepository.save(order);

//        }
        //xu ly list orderItems
        BigDecimal grandTotal = BigDecimal.valueOf(0);
        for (OrderItemParam itemParam : orderParam.getOrderItems()) {
            //kiem tra product ton tai
            //lay toan item theo productId
            if (!productRepository.existsById(itemParam.getProductId())) {
                throw new NotFoundException("Không Tìm Thấy productId " + itemParam.getProductId());
            }
            // lay toan item theo productId
            List<Item> items = itemRepository.findAllByProductIdAndAvailableGreaterThanOrderByCreatedAt(itemParam.getProductId(), 0);
            long totalAvailable = items.stream().mapToInt(Item::getAvailable).sum();
            // nếu tổng sản phẩm nhỏ hơn số lượng order thì gửi thông báo số lượng k đủ
            if (totalAvailable < itemParam.getQuantity()) {
                throw new NotEnoughQuantityException("Không đủ số lượng, vui lòng kiểm tra số lượng!");
            }
            Long productId = itemParam.getProductId();

            Optional<Product> productOptional = productRepository.findById(productId);
            BigDecimal price = (productOptional.get().getPrice());
            // lấy số lượng order
            int quantityCustomer = itemParam.getQuantity();
            //tổng giá sản phẩm = giá sản phẩm * số lượng sản phẩm khách hàng order
            grandTotal = grandTotal.add(price.multiply(new BigDecimal(quantityCustomer)));
            order.setGrandTotal(grandTotal);

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
        return orderMapper.toDTO(order);
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
        return orderRepository.findAllByOrderType(OrderType.CUSTOMER).stream().map(order -> orderMapper.toDTO(order)).collect(Collectors.toList());
    }

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

        }
        newOrder.setOrderStatus(OrderStatus.PENDING);
        newOrder.setCreatedBy(1L);
        newOrder.setAddress(userOptional.get().getAddress());
        newOrder.setUserId(userId);
        newOrder.setOrderType(OrderType.PURCHASE);
        newOrder.setCreatedAt(instant);

        orderRepository.save(newOrder);

        // lấy tổng tiền order của 1 user
        BigDecimal total = userRepository.totalOrderOfUser(userId);
        // set lại orderTotal, CurrencyNames_ceb, cra mới
        userOptional.get().setTotalOrder(total);
        userOptional.get().setCreatedAt(newOrder.getCreatedAt().toString());
        userOptional.get().setCreatedBy(newOrder.getCreatedBy());


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
    public List<Order> findAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override

    public List<OrderResult> findCreateAtByTypeCustomer(String date) {
        return orderRepository.findCreateAtByTypeCustomer(date)
                .stream().map(order -> orderMapper.toDTO(order))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResult> findOrderSevenDay() {
        return orderRepository.findOrderSevenDay()
                .stream().map(order -> orderMapper.toDTO(order))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderPurchaseDTO> findAllOrderPurchase() {
        return orderRepository.findAllOrderPurchase();
    }


}
