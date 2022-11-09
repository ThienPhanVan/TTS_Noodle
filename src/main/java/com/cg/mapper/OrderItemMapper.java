package com.cg.mapper;

import com.cg.dto.order_itemDTO.OrderItemResult;
import com.cg.repositories.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemResult toDTO(OrderItem orderItem){
        return new OrderItemResult()
                .setId(orderItem.getId())
                .setPrice(orderItem.getPrice())
                .setQuantity(orderItem.getQuantity())
                .setItemId(orderItem.getItemId())
                .setOrderId(orderItem.getOrderId())
                .setProductId(orderItem.getProductId());
    }

    public OrderItem toModal(OrderItemResult orderItemResult){
        return new OrderItem()
                .setId(orderItemResult.getId())
                .setPrice(orderItemResult.getPrice())
                .setQuantity(orderItemResult.getQuantity())
                .setItemId(orderItemResult.getItemId())
                .setOrderId(orderItemResult.getOrderId())
                .setProductId(orderItemResult.getProductId());
    }
}
