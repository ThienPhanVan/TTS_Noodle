package com.cg.repositories;

import com.cg.dto.order.OrderResult;
import com.cg.repositories.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT NEW com.cg.dto.order.OrderResult (" +
            "o.id, " +
            "o.grandTotal, " +
            "o.userId, " +
            "o.orderStatus, " +
            "o.address, " +
            "o.createdBy, " +
            "o.createdAt " +
            ")" +
            "FROM Order o " +
            "WHERE o.userId = ?1")
    List<OrderResult> getAllOrderByUserId(Long userId);


    List<Order> findOrderByOrderType(String type);

}
