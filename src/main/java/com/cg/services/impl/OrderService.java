package com.cg.services.impl;


import com.cg.dto.order.*;
import com.cg.mapper.OrderMapper;
import com.cg.exceptions.NotEnoughQuantityException;
import com.cg.exceptions.NotFoundException;
import com.cg.repositories.*;
import com.cg.repositories.model.*;

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
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderResult> findAll() {
        return orderRepository.findAll()
                .stream().map(order -> orderMapper.toDTO(order))
                .collect(Collectors.toList());
    }


    @Override
    public OrderResult findById(Long id) {
        return orderMapper.toDTO(orderRepository.findById(id).get());
    }

    @Override
    @Transactional
    public OrderResult customerOrder (OrderParam orderParam){
//        Order order = orderMapper.toModel(orderParam);
//        order.setUser(new User().setId(order.getUserId()));
//        orderParam.setCreatedAt(Instant.now());
//        orderParam.setCreatedBy(2);
        //orderParam.setUserId(orderParam.getUserId());
        // orderParam.setOrderStatus(OrderStatus.PENDING);
        //Transient

        Long userId = orderParam.getUserId();
        if (userId != null) {
            Optional<User> optional = userRepository.findById(userId);
            if (!optional.isPresent())
                throw new NotFoundException("");
            //TODO:set full name theo UserId
        }
        Order order = orderMapper.toModel(orderParam);
        order.setOrderStatus(OrderStatus.PENDING);
        order.setCreatedBy(2L);
        order.setGrandTotal(new BigDecimal(355));
        order.setCreatedAt(Instant.now());
        order = orderRepository.save(order);
        BigDecimal grandTotal;
        //xu ly list orderItems
        for (OrderItemParam itemParam : orderParam.getOrderItems()) {
            //kiem tra product ton tai
            //lay toan item theo productId

            List<Item> items = itemRepository.findAllByProductIdOrderByCreatedAt(1L);
            long totalAvailable = items.stream()
                    .mapToInt(Item::getAvailable)
                    .sum();
            if (totalAvailable < itemParam.getQuantity())
                throw new NotEnoughQuantityException("Không đủ số lượng, vui lòng kiểm tra số lượng!");
            int quantityCustomer = itemParam.getQuantity();
            Item lastChangeItem = null;
            for (Item item : items) {

                if (quantityCustomer == 0)
                    break;
                int available = item.getAvailable();
                if (quantityCustomer >= available) {
                    quantityCustomer -= available;
                    item.setAvailable(0);
                    item.setSold(available);
                } else {
                    available -= quantityCustomer;
                    item.setAvailable(available);
                    item.setSold(quantityCustomer);
                }
                lastChangeItem = item;
            }
            //order Item
        }

        return orderMapper.toDTO(order);
    }


    @Override
    @Transactional
    public OrderResult createOrderImport(OrderPurchase orderPurchase) {

       Optional<User> userOptional = userRepository.findById(orderPurchase.getUserId());

       if (!userOptional.isPresent()){
           throw new NotFoundException("Không tìm thấy nhà cung cấp!");
       }

      List<OrderItemPurchase> orderItemPurchaseList = orderPurchase.getOrderItemPurchases();

        BigDecimal totalAmount = BigDecimal.valueOf(0);

        int totalQuantity = 0;

        Order newOrder = new Order();

       for (OrderItemPurchase orderItemPurchase : orderItemPurchaseList){

           Long productId = orderItemPurchase.getProductId();

           Optional<Product> productOptional = productRepository.findById(productId);

           if (!productOptional.isPresent()){
               throw new NotFoundException("Không tìm thấy sản phẩm!");
           }

            BigDecimal price = orderItemPurchase.getPrice();

            int quantity = orderItemPurchase.getQuantity();

            totalAmount = totalAmount.add(price.multiply(new BigDecimal(quantity)));

            totalQuantity += quantity;


           newOrder.setId(0L);
           newOrder.setGrandTotal(totalAmount);
           newOrder.setOrderStatus(OrderStatus.PENDING);
           newOrder.setCreatedBy(2L);
           newOrder.setAddress(orderPurchase.getAddress());
           newOrder.setUserId(userOptional.get().getId());
           newOrder.setOrderType(OrderType.CUSTOMER);

           orderRepository.save(newOrder);

       }



       for (OrderItemPurchase orderItemPurchase : orderItemPurchaseList){
            BigDecimal price = orderItemPurchase.getPrice();
            int quantity = orderItemPurchase.getQuantity();
            Long productId = orderItemPurchase.getProductId();


            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setId(0L);
            newOrderItem.setPrice(price);
            newOrderItem.setQuantity(quantity);
            newOrderItem.setOrderId(newOrder.getId());
            newOrderItem.setProductId(productId);

            orderItemRepository.save(newOrderItem);

           Item newItem = new Item();

           newItem.setId(0L);
           newItem.setPrice(newOrderItem.getPrice());
           newItem.setQuantity(quantity);
           newItem.setAvailable(quantity);
           newItem.setSold(0);
           newItem.setDefective(0);
           newItem.setCreatedAt(Instant.now());
           newItem.setUserId(userOptional.get().getId());
           newItem.setOrderId(newOrder.getId());
           newItem.setProductId(productId);

           itemRepository.save(newItem);
       }
        return orderMapper.toDTO(newOrder);
    }

    @Override
    public List<OrderResult> getAllOrderByUserId(Long userId) {
        return orderRepository.getAllOrderByUserId(userId);
    }

}
