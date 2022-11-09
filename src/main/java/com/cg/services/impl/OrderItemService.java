package com.cg.services.impl;

import com.cg.dto.order_itemDTO.OrderItemResult;
import com.cg.mapper.OrderItemMapper;
import com.cg.repositories.OrderItemRepository;
import com.cg.repositories.model.OrderItem;
import com.cg.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderItemResult findById(Long id) {
        return orderItemMapper.toDTO(orderItemRepository.findById(id).get());
    }

    @Override
    public Optional<OrderItem> findByItemId(Long itemId) {
        return orderItemRepository.findByItemId(itemId);
    }

}
