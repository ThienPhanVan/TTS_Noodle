package com.cg.mapper;

<<<<<<< HEAD

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
=======
import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
>>>>>>> development
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
                .setUserId(order.getUserId())
                .setCreatedBy(order.getCreatedBy())
                .setCreatedAt(order.getCreatedAt());

    }

<<<<<<< HEAD
    public Order toModelOrder(OrderCreate orderCreate){
        return new Order(orderCreate.getUserId())
                .setId(orderCreate.getId())
                .setGrandTotal(orderCreate.getGrandTotal())
                .setAddress(orderCreate.getAddress())
                .setOrderStatus(orderCreate.getOrderStatus())
                .setUserId(orderCreate.getUserId())
                .setCreatedBy(orderCreate.getCreatedBy())
                .setCreatedAt(orderCreate.getCreatedAt());
=======
    public Order toModel(OrderParam orderParam){
        return new Order()
                .setUserId(orderParam.getUserId())
                .setAddress(orderParam.getAddress());

>>>>>>> development
    }
}
