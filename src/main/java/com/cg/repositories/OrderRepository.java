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

    List<Order> findAllByUserId(Long userId);

    List<Order> findAllByOrderType(OrderType orderType);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);

<<<<<<< HEAD
//    @Query(
//            "SELECT NEW com.cg.dto.order.OrderListPurchase (" +
//                    "o.id, " +
//                    "o.grandTotal, " +
//                    "o.user, " +
//                    "o.userId," +
//                    "o.orderStatus, " +
//                    "o.createdBy, " +
//                    "o.createdAt) " +
//                    "FROM Order AS o " +
//                    "WHERE o.user.fullName LIKE %?1%"
//    )
//    List<Order> searchOrderBySupplierOOrCreatedAt(String keyword);

=======



>>>>>>> development


    @Query(value = "SELECT * FROM purchase_order", nativeQuery = true)
    List<OrderPurchaseDTO> findAllOrderPurchase();
}
