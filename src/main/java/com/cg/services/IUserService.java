package com.cg.services;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;

import java.util.List;


public interface IUserService  {

    List<UserResult> findAll ();

    UserResult findById(long id);

    UserResult createCustomer(CreateUserParam createUserParam);

    UserResult createSupplier(CreateUserParam createUserParam);

    List<UserResult> findByFullNameAndPhone(String keyword);

    UserResult updateUser(UpdateUserParam updateUserParam);


}
