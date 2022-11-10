package com.cg.services.impl;

import com.cg.dto.orderDTO.OrderParam;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.mapper.OrderMapper;
import com.cg.repositories.OrderRepository;
import com.cg.repositories.UserRepository;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.User;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;


@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderResult create(OrderParam orderParam) {

        orderParam.setCreatedAt(Instant.now());
        orderParam.setUserId(orderParam.getUserId());
        orderParam.setOrderStatus(OrderStatus.PENDING);
        return orderMapper.toDTO(orderRepository.save(orderMapper.toModel(orderParam)));
    }
}
