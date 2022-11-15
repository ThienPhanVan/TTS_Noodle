package com.cg.services.impl;

import com.cg.dto.product.ProductResult;
import com.cg.mapper.ProductMapper;
import com.cg.repositories.ProductRepository;
import com.cg.repositories.model.Product;
import com.cg.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductResult> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

}
