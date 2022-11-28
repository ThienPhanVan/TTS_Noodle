package com.cg.controllers.api;

import com.cg.dto.product.ProductParam;
import com.cg.dto.product.ProductResult;
import com.cg.dto.product.ProductUpdate;
import com.cg.repositories.model.Product;
import com.cg.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/search/{keySearch}")
    public ResponseEntity<?> doSearch(@PathVariable String keySearch){

        List<ProductResult> productResultList = productService.findProductByTitle(keySearch);

        return new ResponseEntity<>(productResultList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showProductId(@PathVariable Long id){

       Optional<Product> productResult = productService.findById(id);

        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody ProductParam productParam){

        ProductResult productResult = productService.createProduct(productParam);

        return new ResponseEntity<>(productResult, HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> doUpdate(@RequestBody ProductUpdate productUpdate){

        ProductResult productResult = productService.updateProduct(productUpdate);

        return new ResponseEntity<>(productResult, HttpStatus.ACCEPTED);
    }
}
