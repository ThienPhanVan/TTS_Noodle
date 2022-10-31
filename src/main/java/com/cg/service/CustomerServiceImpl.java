package com.cg.service;

import com.cg.model.Product;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }
}
