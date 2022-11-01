package com.cg.service.customer;


import com.cg.model.User;

import java.util.Optional;

public interface CustomerService {

    Optional<User> findById(Long id);

}
