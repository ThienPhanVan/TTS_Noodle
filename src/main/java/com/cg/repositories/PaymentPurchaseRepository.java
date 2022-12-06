package com.cg.repositories;

import com.cg.dto.payment.ChartDebt;
import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.repositories.model.PaymentPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentPurchaseRepository extends JpaRepository<PaymentPurchase, Long> {

    List<PaymentPurchase> findAllByUserId(Long id);

    List<PaymentPurchase> findAllByOrderId(Long orderId);

    @Query(name =  "sp_getChartDebtSup", nativeQuery = true)
    List<ChartDebt> getChartDebt();
 }

