package com.cg.services.impl;

import com.cg.dto.order.OrderItemParam;
import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
import com.cg.exceptions.NotEnoughQuantityException;
import com.cg.exceptions.NotFoundException;
import com.cg.mapper.OrderMapper;
import com.cg.repositories.ItemRepository;
import com.cg.repositories.OrderRepository;
import com.cg.repositories.UserRepository;
import com.cg.repositories.model.Item;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.User;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


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

    @Override
    @Transactional
    public OrderResult customerOrder(OrderParam orderParam) {
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
}
