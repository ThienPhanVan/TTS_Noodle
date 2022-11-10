package com.cg.services;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;

import java.util.List;


public interface IUserService  {

    List<UserResult> findAll ();

    List<UserResult>  findAllByRoleId(long id);

    UserResult findById(long id);

    UserResult createCustomer(CreateUserParam createUserParam);

    UserResult createSupplier(CreateUserParam createUserParam);

    List<UserResult> searchCustomer(String keyword);

    List<UserResult> searchSupplier(String keyword);

    UserResult updateUser(UpdateUserParam updateUserParam);


}
