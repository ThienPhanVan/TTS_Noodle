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

<<<<<<< HEAD
    List<UserResult> findAllByFullNameOrPhone(String keyword);
=======
>>>>>>> 3ae44c5fbbd3e2cf0e2c77532d1580ec7c64e679
}
