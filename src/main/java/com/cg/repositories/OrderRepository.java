package com.cg.repositories;

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

    //    @Query("SELECT NEW com.cg.dto.order.Order (" +
//            "o.id, " +
//            "o.grandTotal, " +
//            "o.userId, " +
//            "o.orderStatus, " +
//            "o.orderType, " +
//            "o.address, " +
//            "o.createdBy, " +
//            "o.fullName,"+
//            "o.createdAt " +
//            ")" +
//            "FROM Order o " +
//            "WHERE o.userId = ?1")
    List<Order> findAllByUserId(Long userId);


    List<Order> findAllByOrderType(OrderType orderType);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

}
