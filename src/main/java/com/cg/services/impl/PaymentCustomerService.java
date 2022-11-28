package com.cg.services.impl;

import com.cg.dto.order.OrderResult;
import com.cg.dto.payment.ListPaymentUser;
import com.cg.dto.payment.PaymentCustomerResult;
import com.cg.mapper.PaymentCustomerMapper;
import com.cg.repositories.PaymentCustomerRepository;
import com.cg.services.IPaymentCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentCustomerService implements IPaymentCustomerService {

    @Autowired
    PaymentCustomerMapper paymentCustomerMapper;

    @Autowired
    PaymentCustomerRepository paymentCustomerRepository;

    @Override
    public List<PaymentCustomerResult> findAll() {
            return paymentCustomerRepository.findAll().stream().map(order -> paymentCustomerMapper.toDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<PaymentCustomerResult> getPaymentByUserId(Long id) {
        return paymentCustomerRepository.findAllByUserId(id)
                .stream().map(paymentCustomer -> paymentCustomerMapper.toDTO(paymentCustomer))
                .collect(Collectors.toList());
    }

    @Override
    public List<ListPaymentUser> getPaymentUser() {
        return paymentCustomerRepository.getPaymetnUser();
    }
}
