package com.cg.repositories;


import com.cg.dto.order.*;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByUserId(Long userId);

    List<Order> findAllByOrderType(OrderType orderType);

    @Query(value = "call sp_find_by_order_view()" , nativeQuery = true)
    List<OrderResultDTOS> findAllByOrderView();


    @Query(value = "call sp_find_by_order_view_by_id(:orderId)" , nativeQuery = true)
    OrderResultDTOS findAllByOrderViewById(@Param("orderId") Long id);

    @Query(value = "call sp_find_by_order_view_status_completed" , nativeQuery = true)
    List<OrderResultDTOS> findAllOrderStatusCompleted();

    @Query(value = "call sp_find_by_order_view_status_pending" , nativeQuery = true)
    List<OrderResultDTOS> findAllOrderStatusPending();

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

    @Query(name = "sp_chartSevenDay", nativeQuery = true)
    List<OrderResultChart> findOrderSevenDay();

    @Query(name = "sp_chartOneMonth", nativeQuery = true)
    List<OrderResultChart> findOrderOneMonth();


    @Query(value = "SELECT * FROM purchase_order", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchase();


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
            "WHERE u.fullName LIKE CONCAT('%',:keySearch,'%') AND o.orderType = 'PURCHASE'")
    List<OrderPurchaseView> findOrderByFullNameContainsAndOrderType(@Param("keySearch") String keySearch);


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
            "JOIN User AS u ON u.id = o.userId " +
            "WHERE u.fullName LIKE CONCAT('%',:keySearch,'%') OR u.address LIKE CONCAT('%',:keySearch,'%')  AND o.orderType = 'CUSTOMER' ")
    List<OrderResultDTO> findOrderByFullNameAndAddressContainsAndOrderType(@Param("keySearch") String keySearch);

    @Query(value = "call noodle.getallorderbyrole()", nativeQuery = true)
    List<Order> getAllOrderByRole();

    @Query(value = "call totalOneday()", nativeQuery = true)
    BigDecimal chartOneDay();

}
