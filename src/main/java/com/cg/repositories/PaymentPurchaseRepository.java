package com.cg.repositories;

import com.cg.repositories.model.OrderItem;
import com.cg.repositories.model.PaymentPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentPurchaseRepository extends JpaRepository<PaymentPurchase, Long> {

}
