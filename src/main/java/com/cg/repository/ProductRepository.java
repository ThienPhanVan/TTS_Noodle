package com.cg.repository;

import com.cg.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
=======
import javax.transaction.Transactional;
>>>>>>> 653e392553cc2a4ee033660845917f5dd8a58387

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
