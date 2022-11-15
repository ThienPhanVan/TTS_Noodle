package com.cg.services;


import com.cg.dto.order.OrderPurchase;
import com.cg.dto.order.OrderResult;
import java.util.List;

import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderType;
import org.springframework.data.domain.Sort;


public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrderImport(OrderPurchase orderPurchase);

    List<Order> findAllByUserId(Long userId);

//    List<OrderResult> getAllOrderByUserId(Long userId);

    OrderResult createOrderExport(OrderParam orderParam);

    List<OrderResult> findAllByOrderTypePurchase ();

    List<OrderResult> findAllByOrderTypeCustomer ();

    List<OrderResult> findAllByOrderStatusPending ();

    List<OrderResult> findAllByOrderStatusComplete ();

    List<OrderResult> findAllByOrderStatusCancel ();

}
