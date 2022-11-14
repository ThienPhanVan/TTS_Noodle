package com.cg.mapper;

import com.cg.dto.product.ProductResult;
import com.cg.repositories.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResult toDTO(Product product){
        return new ProductResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setPrice(product.getPrice());
    }

    public Product toModal(ProductResult productResult){
        return new Product()
                .setId(productResult.getId())
                .setTitle(productResult.getTitle())
                .setPrice(productResult.getPrice());
    }

}
