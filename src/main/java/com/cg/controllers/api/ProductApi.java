package com.cg.controllers.api;

import com.cg.dto.product.ProductResult;
import com.cg.repositories.model.Product;
import com.cg.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> showListProduct(){

        List<ProductResult> productResultList = productService.findAll();

        return new ResponseEntity<>(productResultList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showProductId(@PathVariable Long id){

       Optional<Product> productResult = productService.findById(id);

        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }
}
