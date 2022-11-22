package com.cg.repositories;

import com.cg.dto.order.OrderPurchaseDTO;

import com.cg.dto.order.OrderPurchaseView;
import com.cg.dto.order.OrderResult;
import com.cg.dto.order.OrderResultDTO;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserId(Long userId);

    List<Order> findAllByOrderType(OrderType orderType);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);


    @Query(value = "select *  from orders o where o.created_at like %?1% AND o.type = 'CUSTOMER'", nativeQuery = true)
    List<Order> findCreateAtByTypeCustomer(String date);

//    @Query(value = " SELECT  * FROM  orders o  " +
//            "WHERE o.created_at  >= DATE(NOW() - INTERVAL 7 DAY) " +
//            "ORDER BY o.created_at DESC", nativeQuery = true)
    @Query(value = "call noodle.chartSevenDay()" , nativeQuery = true)
    List<Order> findOrderSevenDay();


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
            "o.grandTotal) " +
            "FROM Order AS o " +
            "JOIN User AS u ON u.id = o.userId " +
            "WHERE u.fullName LIKE CONCAT('%',:keySearch,'%') AND o.orderType = 'PURCHASE'" )
    List<OrderPurchaseView> findOrderByFullNameContainsAndOrderType(@Param("keySearch") String keySearch);

}
