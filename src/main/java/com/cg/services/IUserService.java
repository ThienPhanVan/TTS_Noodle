package com.cg.services;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface IUserService  {

    List<UserResult> findAll ();

    List<UserResult>  findAllByRoleId(long id);

    UserResult findById(long id);

    UserResult createCustomer(CreateUserParam createUserParam);

    UserResult createSupplier(CreateUserParam createUserParam);

    List<UserResult> searchCustomer(String keyword);

    List<UserResult> searchSupplier(String keyword);

    UserResult updateUser(UpdateUserParam updateUserParam);

    boolean findUserByRoleId (Long roleId);

    BigDecimal totalOrderOfUser (long id);

    List<UserResult> findAllByFullNameOrPhone(String keyword);
}
