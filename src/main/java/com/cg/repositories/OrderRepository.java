package com.cg.repositories;

import com.cg.dto.orderDTO.OrderResult;
import com.cg.repositories.model.Order;
import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT NEW com.cg.dto.orderDTO.OrderResult (" +
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

}
