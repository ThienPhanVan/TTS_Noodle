package com.cg.mapper;

import com.cg.dto.order.OrderItemPurchase;
import com.cg.dto.order_item.OrderItemResult;
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

    public OrderItem toModal(OrderItemPurchase orderItemPurchase){
        return new OrderItem()
                .setPrice(orderItemPurchase.getPrice())
                .setQuantity(orderItemPurchase.getQuantity())
                .setProductId(orderItemPurchase.getProductId());
    }
}
