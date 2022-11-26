package com.cg.repositories;


import com.cg.dto.order.OrderPurchaseDTO;
import com.cg.dto.order.OrderResultDTO;
import com.cg.dto.order.OrderPurchaseView;
import com.cg.dto.order.OrderResult;
import com.cg.dto.order.OrderResultDTO;
import com.cg.dto.order.OrderPurchaseView;
import com.cg.dto.order.OrderResultChart;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByUserId(Long userId);

    List<Order> findAllByOrderType(OrderType orderType);


    @Query(value = "SELECT NEW com.cg.dto.order.OrderResultDTO (" +
            "o.id, " +
            "o.createdAt, " +
            "o.fullName, " +
            "o.address, " +
            "o.orderType, " +
            "o.orderStatus, " +
            "o.grandTotal, " +
            "p.paid) " +
            "FROM Order AS o " +
            "JOIN PaymentCustomer AS p ON p.orderId = o.id " +
            "WHERE o.orderType = 'CUSTOMER' " )
    List<OrderResultDTO> findAllByOrderView();

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

    @Query(name = "noodle.chartSevenDay", nativeQuery = true)
    List<OrderResultChart> findOrderSevenDay();

    @Query(name = "noodle.chartOneMonth", nativeQuery = true)
    List<OrderResultChart> findOrderOneMonth();


    @Query(value = "SELECT * FROM purchase_order", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchase();

//    @Query(value = "SELECT NEW com.cg.dto.order.OrderResultDTO (" +
//            "o.id, " +
//            "o.createdAt, " +
//            "o.fullName, " +
//            "o.address, " +
//            "o.orderType, " +
//            "o.orderStatus, " +
//            "o.grandTotal) " +
//            "FROM Order AS o " +
//            "WHERE o.orderType = 'CUSTOMER' AND o.orderStatus = 'COMPLETED'" )
//    List<OrderResultDTO> findAllOrderStatusCompleted();


//    @Query(value = "SELECT NEW com.cg.dto.order.OrderResultDTO (" +
//            "o.id, " +
//            "o.createdAt, " +
//            "o.fullName, " +
//            "o.address, " +
//            "o.orderType, " +
//            "o.orderStatus, " +
//            "o.grandTotal) " +
//            "FROM Order AS o " +
//            "WHERE o.orderType = 'CUSTOMER' AND o.orderStatus = 'PENDING'" )
//    List<OrderResultDTO> findAllOrderStatusPending();
//    List<OrderResultDTO> findAllOrderPurchaseStatusPending();


    @Query(value = "SELECT * FROM purchase_order_status_completed", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchaseStatusComplete();

    @Query(value = "SELECT * FROM purchase_order_status_cancelled", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchaseStatusCancel();

    @Query(value = "SELECT * FROM purchase_order_status_pending", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchaseStatusPending();

    //java.lang.Long, java.lang.Long, java.time.Instant, java.lang.Long,
    // java.lang.String, com.cg.repositories.model.OrderStatus, java.math.BigDecimal)'
    @Query("SELECT NEW com.cg.dto.order.OrderPurchaseView (" +
            "o.id, " +
            "o.userId, " +
            "o.createdAt, " +
            "o.createdBy, " +
            "u.fullName, " +
            "o.orderType, " +
            "o.orderStatus, " +
            "o.grandTotal, " +
            "p.paid) " +
            "FROM Order AS o " +
            "JOIN User AS u ON u.id = o.userId " +
            "JOIN PaymentPurchase AS p ON p.orderId = o.id " +
            "WHERE u.fullName LIKE CONCAT('%',:keySearch,'%') AND o.orderType = 'PURCHASE'" )
    List<OrderPurchaseView> findOrderByFullNameContainsAndOrderType(@Param("keySearch") String keySearch);


    @Query(value = "call noodle.getallorderbyrole()", nativeQuery = true)
    List<Order> getAllOrderByRole();

    @Query(value = "call noodle.totalOneday()", nativeQuery = true)
    BigDecimal chartOneDay();


}
