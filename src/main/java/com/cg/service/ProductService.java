package com.cg.service;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

}
