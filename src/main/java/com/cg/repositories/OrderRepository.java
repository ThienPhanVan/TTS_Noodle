package com.cg.repositories;

import com.cg.repositories.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//    @Query(value =
//            "SELECT * FROM orders o join users u  on  o.created_by = u.id")
//
}
