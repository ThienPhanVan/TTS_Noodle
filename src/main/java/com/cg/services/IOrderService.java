package com.cg.services;


import com.cg.dto.order.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.cg.dto.order.OrderResult;
import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderType;
import com.cg.repositories.model.PaymentPurchase;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;


public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrderImport(OrderPurchase orderPurchase);

    List<OrderResult> findAllByUserId(Long userId);


    OrderResult createOrderExport(OrderParam orderParam);

    List<OrderResult> findAllByOrderTypeCustomer ();

    List<OrderResultChart> findOrderSevenDay();
    List<OrderResultChart> findOrderOneMonth();

    List<OrderPurchaseDTO> findAllOrderPurchase();

    List<OrderResultDTOS> findAllOrderStatusCompleted();

    List<OrderPurchaseDTO> findAllOrderPurchaseStatusPending();

    List<OrderPurchaseDTO> findAllOrderPurchaseStatusCancel();

    List<OrderPurchaseDTO> findAllOrderPurchaseStatusComplete();

    List<OrderPurchaseDTO> findOrderByFullNameContainsAndOrderType(String keySearch);

    List<OrderResultDTO> findOrderByFullNameAndAddressContainsAndOrderType(String keySearch);

    BigDecimal chartOneDay();

    List<OrderResultDTOS> findAllOrderStatusPending();

    OrderChangeStatus changeStatus(OrderChangeStatus orderChangeStatus);

    List<OrderResultDTOS> findAllByOrderView();

    OrderResultDTOS findAllByOrderViewById(Long id);

     BigDecimal totalOrderOneMonth();

        OrderResultPaidDTO findOrderByIdPaidCustomer(Long id);

     PaymentPurchaseResult doPaid(OrderPaid orderPaid);

 }
