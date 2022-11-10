package com.cg.mapper;

<<<<<<< HEAD
import com.cg.dto.orderDTO.OrderCreate;
=======
import com.cg.dto.orderDTO.OrderParam;
>>>>>>> development
import com.cg.dto.orderDTO.OrderResult;
import com.cg.repositories.model.Order;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
=======

>>>>>>> development
@Component
public class OrderMapper {

    public OrderResult toDTO(Order order){
        return new OrderResult()
                .setId(order.getId())
<<<<<<< HEAD
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

=======
                .setUserId(order.getUserId())
                .setAddress(order.getAddress())
                .setGrandTotal(order.getGrandTotal())
                .setOrderStatus(order.getOrderStatus())
                .setCreatedAt(order.getCreatedAt())
                .setCreatedBy(order.getCreatedBy());
    }

    public Order toModel(OrderParam orderParam){
        return new Order(orderParam.getUserId())
                .setAddress(orderParam.getAddress())
                .setGrandTotal(orderParam.getGrandTotal())
                .setOrderStatus(orderParam.getOrderStatus())
                .setCreatedAt(orderParam.getCreatedAt())
                .setCreatedBy(orderParam.getCreatedBy());
    }
>>>>>>> development
}
