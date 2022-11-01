package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD:src/main/java/com/cg/repository/UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
=======
public interface CustomerRepository extends JpaRepository<Customer, Long> {
>>>>>>> development:src/main/java/com/cg/repository/CustomerRepository.java
}
