package com.cg.service.customer;

<<<<<<< HEAD
import com.cg.model.Customer;
import com.cg.service.IGeneralService;
import org.springframework.stereotype.Service;

public interface CustomerService extends IGeneralService<Customer> {
=======

import com.cg.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);

>>>>>>> b7c1f520bb3b8cf55dab9d535d905e9d5f62136d
}
