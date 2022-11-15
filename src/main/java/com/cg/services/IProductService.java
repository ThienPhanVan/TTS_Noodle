package com.cg.services;

import com.cg.dto.product.ProductResult;
import com.cg.repositories.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);

    List<ProductResult> findAll();


}
