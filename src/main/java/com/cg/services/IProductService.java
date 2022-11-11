package com.cg.services;

import com.cg.repositories.model.Product;

import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);
}
