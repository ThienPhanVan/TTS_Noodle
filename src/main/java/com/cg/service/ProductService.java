package com.cg.service;

import com.cg.model.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

}
