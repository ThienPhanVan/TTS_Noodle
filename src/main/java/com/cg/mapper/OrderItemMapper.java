package com.cg.mapper;


import com.cg.dto.orderItem.OrderItemParam;
import com.cg.repositories.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public OrderItem toModel(OrderItemParam orderItemParam) {
        return new OrderItem()
                .setId(orderItemParam.getItemId())
                .setPrice(orderItemParam.getPrice())
                .setQuantity(orderItemParam.getQuantity())
                .setItemId(orderItemParam.getItemId())
                .setOrderId(orderItemParam.getOrderId())
                .setProductId(orderItemParam.getProductId());
    }
}
