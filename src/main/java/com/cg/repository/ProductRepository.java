package com.cg.repository;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.cg.model.Product;
>>>>>>> sinh_dev1
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
=======
import com.cg.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
>>>>>>> development

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
<<<<<<< HEAD

=======
>>>>>>> sinh_dev1
}
