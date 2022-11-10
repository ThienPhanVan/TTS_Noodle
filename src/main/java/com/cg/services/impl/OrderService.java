package com.cg.services.impl;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.mapper.OrderMapper;
import com.cg.repositories.*;
import com.cg.repositories.model.*;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

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
    public OrderResult createOrderImport(OrderCreate orderCreate) {

        orderCreate.setId(0L);
        orderCreate.setOrderStatus(OrderStatus.PENDING);
        orderCreate.setCreatedBy(1L);
        orderCreate.setUserId(orderCreate.getUserId());
        orderCreate.setCreatedAt(Instant.now());

        Order newOrder = orderMapper.toModelOrder(orderCreate);
        orderRepository.save(newOrder);


        return orderMapper.toDTO(newOrder);

    }

    @Override
    public List<OrderResult> getAllOrderByUserId(Long userId) {
        return orderRepository.getAllOrderByUserId(userId);
    }


}
