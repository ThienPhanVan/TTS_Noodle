package com.cg.service;

import com.cg.model.Product;

import java.util.Optional;

public interface CustomerService {

    Optional<Product> findById(Long id);

}
