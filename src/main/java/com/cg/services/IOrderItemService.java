package com.cg.services;

import com.cg.dto.order_item.OrderItemResult;
import com.cg.repositories.model.OrderItem;

import java.util.Optional;

public interface IOrderItemService {

    Optional<OrderItem> findById(Long id);

    Optional<OrderItem> findByItemId(Long itemId);

    Optional<OrderItem> getOrderItemByOrderId(Long oderItemId);

}
