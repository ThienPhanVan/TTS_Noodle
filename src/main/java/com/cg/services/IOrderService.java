package com.cg.services;


import com.cg.dto.order.OrderPurchase;
import com.cg.dto.order.OrderResult;
import java.util.List;

import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;


public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrderImport(OrderPurchase orderPurchase);


    List<OrderResult> getAllOrderByUserId(Long userId);

    OrderResult customerOrder(OrderParam orderParam);
}
