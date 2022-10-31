package com.cg.service.customer;


import com.cg.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);

}
