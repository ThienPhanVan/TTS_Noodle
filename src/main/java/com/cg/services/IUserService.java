package com.cg.services;

import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUserService  {

    List<UserResult> findAll ();

    UserResult findByRoleId(long id);

    UserResult createUser(UserParam userParam);

}
