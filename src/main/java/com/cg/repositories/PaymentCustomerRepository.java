package com.cg.repositories;

import com.cg.repositories.model.PaymentCustomer;
import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface PaymentCustomerRepository extends JpaRepository<PaymentCustomer, Long> {

}
