package com.cg.repository;

<<<<<<< HEAD
=======
import com.cg.model.Customer;
>>>>>>> development
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
