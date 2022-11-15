package com.cg.mapper;

import com.cg.dto.order.OrderListPurchase;
import com.cg.dto.order.OrderPurchase;
import com.cg.dto.order.OrderResult;
import com.cg.dto.order.OrderParam;

import com.cg.repositories.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {
@Autowired
    UserMapper userMapper;

    @Autowired
    private UserMapper userMapper;

    public OrderResult toDTO(Order order){
        return new OrderResult()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setAddress(order.getAddress())
                .setOrderStatus(order.getOrderStatus())
                .setOrderType(order.getOrderType())
                .setUserId(order.getUserId())
//                .setUser(userMapper.toDTO(order.getUser()))
                .setFullName(order.getFullName())
                .setCreatedBy(order.getCreatedBy())
                .setCreatedAt(order.getCreatedAt());

    }

    public OrderListPurchase toDTOList (Order order){
        return new OrderListPurchase()
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setOrderStatus(order.getOrderStatus())
                .setUser(userMapper.toDTO(order.getUser()))
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
                .setId(orderParam.getId())
                .setUserId(orderParam.getUserId())

                .setAddress(orderParam.getAddress());
<<<<<<< HEAD
=======


>>>>>>> thien_dev
    }
}
