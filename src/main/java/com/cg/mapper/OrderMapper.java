package com.cg.mapper;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.repositories.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResult toDTO(Order order){
        return new OrderResult()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setAddress(order.getAddress())
                .setStatus(order.getOrderStatus())
                .setUserId(order.getUserId())
                .setCreatedBy(order.getCreatedBy());

    }

    public Order toModelOrder(OrderCreate orderCreate){
        return new Order()
                .setId(orderCreate.getId())
                .setGrandTotal(orderCreate.getGrandTotal())
                .setAddress(orderCreate.getAddress())
                .setOrderStatus(orderCreate.getStatus())
                .setUserId(orderCreate.getUserId())
                .setCreatedBy(orderCreate.getCreatedBy());
    }

}
