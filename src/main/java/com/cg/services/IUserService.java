package com.cg.services;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;

import java.util.List;


public interface IUserService  {

    List<UserResult> findAll ();

    UserResult findByRoleId(long id);

    UserResult findById(long id);

    UserResult createUser(CreateUserParam createUserParam);

//    UserResult updateUser(UserResult userResult, User user);

//    User findUserById(Long id);
//
//    List<UserResult> findUserByFullNameAndPhone(String keyword);



}
