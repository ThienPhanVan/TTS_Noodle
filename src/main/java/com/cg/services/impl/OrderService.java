package com.cg.services.impl;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.dto.order_itemDTO.OrderItemResult;
import com.cg.exceptions.DataInputException;
import com.cg.mapper.OrderItemMapper;
import com.cg.mapper.OrderMapper;
import com.cg.repositories.*;
import com.cg.repositories.model.*;
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

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RoleRepository roleRepository;

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
        orderCreate.setStatus(OrderStatus.PENDING);
        orderCreate.setCreatedBy(1L);

        return orderMapper.toDTO(orderRepository.save(orderMapper.toModelOrder(orderCreate)));

    }

    @Override
    public List<OrderResult> getAllOrderByUserId(Long userId) {
        return orderRepository.getAllOrderByUserId(userId);
    }


}
