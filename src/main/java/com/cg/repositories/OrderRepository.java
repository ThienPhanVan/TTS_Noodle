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

}
