package com.cg.mapper;

import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;
import com.cg.repositories.model.UserStatus;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResult toDTO (User user){
        return new UserResult()
                .setId(user.getId())
                .setRoleId(user.getRoleId())
                .setFullName(user.getFullName())
                .setPhone(user.getPhone())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setStatus(user.getStatus()) ;
    }
    public User toModel (UserParam userParam){
        return new User()
                .setRoleId(userParam.getRoleId())
                .setFullName(userParam.getFullName())
                .setPhone(userParam.getPhone())
                .setEmail(userParam.getEmail())
                .setAddress(userParam.getAddress())
                .setStatus(UserStatus.NEW);
    }

}
