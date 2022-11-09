package com.cg.services;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.dto.order_itemDTO.OrderItemResult;

import java.util.List;

public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult saveOrderImport(OrderCreate orderCreate, OrderItemResult orderItemResult);
}
