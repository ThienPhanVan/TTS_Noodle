package com.cg.repositories;

import com.cg.repositories.model.PaymentPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentPurchaseRepository extends JpaRepository<PaymentPurchase, Long> {

    List<PaymentPurchase> findAllByUserId(Long id);

 }

