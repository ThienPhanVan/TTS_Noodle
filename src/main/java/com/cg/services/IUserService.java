package com.cg.services;

import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;

import java.util.List;


public interface IUserService  {

    List<UserResult> findAll ();

    UserResult findById(long id);

    UserResult createUser(UserParam userParam);

    UserResult updateUser(UserResult userResult,User user);


}
