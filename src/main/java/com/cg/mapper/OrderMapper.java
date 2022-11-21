package com.cg.mapper;

import com.cg.dto.order.*;

import com.cg.repositories.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class OrderMapper {

    @Autowired
    UserMapper userMapper;

    public OrderResult toDTO(Order order) {
        return new OrderResult()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setAddress(order.getAddress())
                .setOrderStatus(order.getOrderStatus())
                .setOrderType(order.getOrderType())
                .setUserId(order.getUserId())
                .setFullName(order.getFullName())
                .setCreatedBy(order.getCreatedBy())
                .setCreatedAt(order.getCreatedAt());
    }

    public ListOrderResult toListDTO(Order order) {
        return new ListOrderResult()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setAddress(order.getAddress())
                .setOrderStatus(order.getOrderStatus())
                .setFullName(order.getFullName())
                .setCreatedAt(order.getCreatedAt());

    }

    public OrderResultChart toChart(Order order) {
        return new OrderResultChart()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setAddress(order.getAddress())
                .setOrderStatus(order.getOrderStatus())
                .setOrderType(order.getOrderType())
                .setUserId(order.getUserId())
                .setFullName(order.getFullName())
                .setCreatedBy(order.getCreatedBy())
                .setCreatedAt(order.getCreatedAt());
    }

    public OrderListPurchase toDTOList(Order order) {
        return new OrderListPurchase()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setUserId(order.getUserId())
                .setCreatedAt(order.getCreatedAt());
    }

    public Order toModelOrder(OrderPurchase orderPurchase) {
        return new Order()
                .setCreatedAt(Instant.parse(orderPurchase.getCreatedAt()))
                .setUserId(orderPurchase.getUserId());

    }

    public Order toModel(OrderParam orderParam) {
        return new Order()
                .setId(orderParam.getId())
                .setPhone(orderParam.getPhone())
                .setAddress(orderParam.getAddress())
                .setFullName(orderParam.getFullName());




    }
}
