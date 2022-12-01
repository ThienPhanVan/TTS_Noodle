package com.cg.services.impl;

import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.dto.payment.PaymentResult;
import com.cg.mapper.PaymentMapper;
import com.cg.repositories.PaymentPurchaseRepository;
import com.cg.repositories.model.PaymentPurchase;
import com.cg.services.IPaymentPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentPurchaseService implements IPaymentPurchaseService {

    @Autowired
    private PaymentPurchaseRepository paymentPurchaseRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Optional<PaymentPurchase> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PaymentResult> findAllByUserId(Long id) {
        return paymentPurchaseRepository.findAllByUserId(id)
                .stream().map(paymentPurchase -> paymentMapper.toDTO(paymentPurchase))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentPurchase> findAllByOrderId(Long orderId) {
        return paymentPurchaseRepository.findAllByOrderId(orderId);
    }
}
