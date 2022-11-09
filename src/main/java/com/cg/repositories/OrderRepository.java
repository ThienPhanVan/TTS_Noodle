package com.cg.repositories;

import com.cg.dto.orderDTO.OrderResult;
import com.cg.repositories.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

//    @Query
//
//    List<OrderResult> findAllByRole(String Role);
}
