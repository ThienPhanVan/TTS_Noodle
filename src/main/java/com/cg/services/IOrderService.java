package com.cg.services;

<<<<<<< HEAD
import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.dto.order_itemDTO.OrderItemResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.User;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrderImport(OrderCreate orderCreate);


    List<OrderResult> getAllOrderByUserId(Long userId);

=======

import com.cg.dto.orderDTO.OrderParam;
import com.cg.dto.orderDTO.OrderResult;

public interface IOrderService {

    OrderResult create(OrderParam orderParam);
>>>>>>> development
}
