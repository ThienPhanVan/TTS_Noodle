package com.cg.services;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;

import java.util.List;
import java.util.Optional;


public interface IUserService  {

    List<UserResult> findAll ();

    UserResult findById(long id);

    UserResult createCustomer(CreateUserParam createUserParam);

    UserResult createSupplier(CreateUserParam createUserParam);

    List<UserResult> findByFullNameAndPhone(String keyword);

    UserResult updateUser(UpdateUserParam updateUserParam);

}
