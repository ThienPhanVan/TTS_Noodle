package com.cg.repository;

import com.cg.model.Product;
<<<<<<< HEAD
=======
import org.springframework.context.annotation.Bean;
>>>>>>> thien_dev
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

}
