package com.cg.services;


import com.cg.dto.order.*;

import java.util.List;

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

    List<OrderListPurchase> findAllByOrderTypePurchaseList ();

    List<OrderListPurchase> findAllByOrderTypeCustomerList();
    List<OrderResult> findAllByOrderTypePurchase ();

    List<OrderResult> findAllByOrderTypeCustomer ();

    List<OrderResult> findAllByOrderStatusPending ();

    List<OrderResult> findAllByOrderStatusComplete ();

    List<OrderResult> findAllByOrderStatusCancel ();

    List<OrderListPurchase> searchOrderBySupplierOOrCreatedAt(String keyword);

}
