package com.cg.mapper;

import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
import com.cg.repositories.model.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {

    public OrderResult toDTO(Order order){
        return new OrderResult()
                .setId(order.getId())
                .setUserId(order.getUserId())
                .setAddress(order.getAddress())
                .setGrandTotal(order.getGrandTotal())
                .setOrderStatus(order.getOrderStatus())
                .setCreatedAt(order.getCreatedAt())
                .setCreatedBy(order.getCreatedBy());
    }

    public Order toModel(OrderParam orderParam){
        return new Order()
                .setUserId(orderParam.getUserId())
                .setAddress(orderParam.getAddress());

    }
}
