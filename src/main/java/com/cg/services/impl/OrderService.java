package com.cg.services.impl;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.mapper.OrderMapper;
import com.cg.repositories.OrderRepository;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    public OrderResult createOrder(OrderCreate orderCreate) {

        Optional<Order> order = orderRepository.findById(orderCreate.getId());

        if (!order.isPresent()){
            throw new RuntimeException("ID không tồn tại");
        }

        Order newOrder = orderMapper.toModelCreate(orderCreate);

        newOrder.setOrderStatus(OrderStatus.PENDING);

        return orderMapper.toDTO(orderRepository.save(newOrder));
    }
}
