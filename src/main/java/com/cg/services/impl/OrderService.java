package com.cg.services.impl;


import com.cg.dto.order.*;
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
import java.time.Instant;
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
            if (!optional.isPresent()) throw new NotFoundException("Không Tìm Thấy Id Khách Hàng!");
        }
        Order order = orderMapper.toModel(orderParam);
        order.setFullName(orderParam.getFullName());
        order.setPhone(orderParam.getPhone());
        order.setAddress(orderParam.getAddress());
        order.setCreatedAt(Instant.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setCreatedBy(2L);
        order.setOrderType(OrderType.CUSTOMER);
        order.setGrandTotal(new BigDecimal(0));
        order = orderRepository.save(order);

        BigDecimal grandTotal;
        //xu ly list orderItems
        for (OrderItemParam itemParam : orderParam.getOrderItems()) {
            System.out.println(itemParam);
            //kiem tra product ton tai
            //lay toan item theo productId
            if (!productRepository.existsById(itemParam.getProductId()))
                throw new NotFoundException("Không Tìm Thấy productId " + itemParam.getProductId());
            // lay toan item theo productId
            List<Item> items = itemRepository.findAllByProductIdAndAvailableGreaterThanOrderByCreatedAt(itemParam.getProductId(), 0);
            long totalAvailable = items.stream().mapToInt(Item::getAvailable).sum();
            // nếu tổng sản phẩm nhỏ hơn số lượng order thì gửi thông báo số lượng k đủ
            if (totalAvailable < itemParam.getQuantity()) {
                throw new NotEnoughQuantityException("Không đủ số lượng, vui lòng kiểm tra số lượng!");
            }
            // lấy số lượng order
            int quantityCustomer = itemParam.getQuantity();

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
        //order Item
        return orderMapper.toDTO(order);
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

        List<OrderItemPurchase> orderItemPurchaseList = orderPurchase.getOrderItemPurchases();

        BigDecimal totalAmount = BigDecimal.valueOf(0);

        int totalQuantity = 0;

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

            totalQuantity += quantity;


            newOrder.setGrandTotal(totalAmount);
            newOrder.setOrderStatus(OrderStatus.PENDING);
            newOrder.setCreatedBy(2L);
            newOrder.setAddress(orderPurchase.getAddress());
            newOrder.setUserId(userOptional.get().getId());
            newOrder.setOrderType(OrderType.CUSTOMER);
            newOrder.setCreatedAt(Instant.now());

            orderRepository.save(newOrder);

        }
        for (OrderItemPurchase orderItemPurchase : orderItemPurchaseList) {
            BigDecimal price = orderItemPurchase.getPrice();
            int quantity = orderItemPurchase.getQuantity();
            Long productId = orderItemPurchase.getProductId();

            Item newItem = new Item();

            OrderItem newOrderItem = new OrderItem();

            newOrderItem.setPrice(price);
            newOrderItem.setQuantity(quantity);
            newOrderItem.setOrderId(newOrder.getId());
            newOrderItem.setProductId(productId);


            newItem.setPrice(newOrderItem.getPrice());
            newItem.setQuantity(quantity);
            newItem.setAvailable(quantity);
            newItem.setSold(0);
            newItem.setDefective(0);
            newItem.setCreatedAt(Instant.now());
            newItem.setCreatedBy(1L);
            newItem.setUserId(userOptional.get().getId());
            newItem.setOrderId(newOrder.getId());
            newItem.setProductId(productId);

            itemRepository.save(newItem);

            newOrderItem.setItemId(newItem.getId());

            orderItemRepository.save(newOrderItem);
        }
        return orderMapper.toDTO(newOrder);
    }

    @Override
    public List<Order> findAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

}
