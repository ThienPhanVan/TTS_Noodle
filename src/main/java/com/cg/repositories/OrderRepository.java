package com.cg.repositories;

import com.cg.dto.order.OrderPurchaseDTO;

import com.cg.dto.order.OrderResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByUserId(Long userId);

    List<Order> findAllByOrderType(OrderType orderType);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);


    @Query(value = "select *  from orders o where o.created_at like %?1% AND o.type = 'CUSTOMER' and o.user_id is null ", nativeQuery = true)
    List<Order> findCreateAtByTypeCustomer(String date);

//    @Query(value = " SELECT  * FROM  orders o  " +
//            "WHERE o.created_at  >= DATE(NOW() - INTERVAL 7 DAY) " +
//            "ORDER BY o.created_at DESC", nativeQuery = true)
    @Query(value = "call noodle.chartSevenDay()" , nativeQuery = true)
    List<Order> findOrderSevenDay();


    @Query(value = "SELECT * FROM purchase_order", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchase();
    @Query(value = "call noodle.getallorderbyrole()" , nativeQuery = true)
    List<Order> getAllOrderByRole();

}
