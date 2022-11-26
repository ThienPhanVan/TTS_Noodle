package com.cg.services;


import com.cg.dto.order.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.cg.dto.order.OrderResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderType;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;


public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrderImport(OrderPurchase orderPurchase);

    List<OrderResult> findAllByUserId(Long userId);

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

    void updateOrderStatus (OrderResult orderResult);

    List<OrderResultChart> findOrderSevenDay();
    List<OrderResultChart> findOrderOneMonth();

    List<OrderPurchaseDTO> findAllOrderPurchase();

    List<OrderResultDTO> findAllOrderStatusCompleted();

    List<OrderPurchaseDTO> findAllOrderPurchaseStatusPending();

    List<OrderPurchaseDTO> findAllOrderPurchaseStatusCancel();

    List<OrderPurchaseDTO> findAllOrderPurchaseStatusComplete();

    List<OrderPurchaseDTO> findOrderByFullNameContainsAndOrderType(String keySearch);

    List<OrderResultDTO> findOrderByFullNameAndAddressContainsAndOrderType(String keySearch);

    List<OrderResult> getAllOrderByRole();

    BigDecimal chartOneDay();

    List<OrderResultDTO> findAllOrderStatusPending();

    OrderResultDTO setStatusOrderPending(Long id);

    OrderChangeStatus changeStatus(OrderChangeStatus orderChangeStatus);

    List<OrderResultDTO> findAllByOrderView();



}
