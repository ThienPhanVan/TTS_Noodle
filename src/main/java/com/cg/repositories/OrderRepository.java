package com.cg.repositories;


import com.cg.repositories.model.Order;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

}
