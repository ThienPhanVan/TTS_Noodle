package com.cg.services.impl;

import com.cg.dto.product.ProductParam;
import com.cg.dto.product.ProductResult;
import com.cg.dto.product.ProductUpdate;
import com.cg.exceptions.DataInputException;
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
        return productRepository.findAllByOrderByIdDesc()
                .stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResult> findProductByTitle(String title) {
        return productRepository.findProductByTitleContains(title)
                .stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResult findProductById(Long productId) {
        Optional<Product> productResult = productRepository.findById(productId);
        return productMapper.toDTO(productResult.get());
    }

    @Override
    public ProductResult createProduct(ProductParam productParam) {

        Product newProduct = new Product();

        newProduct.setTitle(productParam.getTitle());
        newProduct.setPrice(productParam.getPrice());

        return productMapper.toDTO(productRepository.save(newProduct));
    }

    @Override
    public ProductResult updateProduct(ProductUpdate productUpdate) {

        Optional<Product> productOptional = productRepository.findById(productUpdate.getId());

        if (!productOptional.isPresent()){
            throw new DataInputException("Sản phẩm không tồn tại");
        }

        Product newProduct = productOptional.get();

        newProduct.setPrice(productUpdate.getPrice());

        return productMapper.toDTO(productRepository.save(newProduct));
    }

}
