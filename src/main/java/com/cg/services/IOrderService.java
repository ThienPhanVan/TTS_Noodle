package com.cg.services;


import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;

public interface IOrderService {

    OrderResult customerOrder(OrderParam orderParam);
}
