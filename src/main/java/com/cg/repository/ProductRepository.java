package com.cg.repository;

import com.cg.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
=======

import javax.transaction.Transactional;
>>>>>>> development

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
