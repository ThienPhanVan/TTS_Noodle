package com.cg.services;


import com.cg.dto.orderDTO.OrderParam;
import com.cg.dto.orderDTO.OrderResult;

public interface IOrderService {

    OrderResult create(OrderParam orderParam);
}
