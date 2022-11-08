package com.cg.services;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;

import java.util.List;

public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrder(OrderCreate orderCreate);
}
