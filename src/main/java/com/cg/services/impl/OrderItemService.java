package com.cg.services.impl;

import com.cg.dto.orderItem.OrderItemView;
import com.cg.dto.order_item.OrderItemChart;
import com.cg.dto.order_item.OrderItemProfit;
import com.cg.dto.order_item.OrderItemProfitOD;
import com.cg.dto.order_item.OrderItemResult;
import com.cg.mapper.OrderItemMapper;
import com.cg.repositories.OrderItemRepository;
import com.cg.repositories.model.OrderItem;
 import com.cg.repositories.model.OrderType;
import com.cg.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;


    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public Optional<OrderItem> findByItemId(Long itemId) {
        return orderItemRepository.findByItemId(itemId);
    }

    @Override
    public Optional<OrderItem> getOrderItemByOrderId(Long oderItemId) {
        return orderItemRepository.getOrderItemByOrderId(oderItemId);
    }

    @Override
    public List<OrderItemResult> findAll() {
        return orderItemRepository.findAll()
                .stream()
                .map(orderItem -> orderItemMapper.toDTO(orderItem))
                .collect(Collectors.toList());
    }

    @Override
    public Integer chartQuantityNoodleOneDay(String type) {
        return orderItemRepository.chartQuantityNoodleOneDay(type);
    }

    @Override
    public List<OrderItemChart> chartQuantityNoodleOneWeek(String type) {
        return orderItemRepository.chartQuantityNoodleOneWeek(type);
    }

    @Override
    public List<OrderItemChart> chartQuantityNoodleOneMonth(String type) {
        return orderItemRepository.chartQuantityNoodleOneMonth(type);
    }

    @Override
    public List<OrderItemProfitOD> getProfit1Day() {
        return orderItemRepository.getProfit1Day();
    }

    @Override
    public List<OrderItemProfit> getProfit1Week() {
        return orderItemRepository.getProfit1Week();
    }
<<<<<<< HEAD
=======

>>>>>>> development
    public List<OrderItemView> findAllOrderView(Long orderId) {
        return orderItemRepository.findAllOrderView(orderId);
    }

    @Override
    public List<OrderItemResult> findAllByOrderId(Long orderId) {
        return orderItemRepository.findAllByOrderId(orderId)
                .stream().map(orderItem -> orderItemMapper.toDTO(orderItem))
                .collect(Collectors.toList());
    }
}
