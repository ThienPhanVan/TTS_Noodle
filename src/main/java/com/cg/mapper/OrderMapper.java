package com.cg.mapper;

import com.cg.dto.order.OrderPurchase;
import com.cg.dto.order.OrderResult;
import com.cg.dto.order.OrderParam;

import com.cg.repositories.model.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {

    public OrderResult toDTO(Order order){
        return new OrderResult()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setAddress(order.getAddress())
                .setOrderStatus(order.getOrderStatus())
                .setOrderType(order.getOrderType())
                .setUserId(order.getUserId())
                .setCreatedBy(order.getCreatedBy())
                .setCreatedAt(order.getCreatedAt());

    }

    public Order toModelOrder(OrderPurchase orderPurchase) {
        return new Order()
                .setAddress(orderPurchase.getAddress())
                .setUserId(orderPurchase.getUserId());

    }
    public Order toModel (OrderParam orderParam){
        return new Order()
                .setUserId(orderParam.getUserId())
                .setAddress(orderParam.getAddress());

    }
}
