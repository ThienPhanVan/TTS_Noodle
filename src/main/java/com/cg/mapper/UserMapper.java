package com.cg.mapper;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResult toDTO(User user) {
        return new UserResult()
                .setId(user.getId())
                .setRoleId(user.getRoleId())
                .setFullName(user.getFullName())
                .setPhone(user.getPhone())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setStatus(user.getStatus())
                .setUsername(user.getUsername())
                .setAvatarUrl(user.getAvatarUrl());
    }

//    public UpdateUserParam toUpdateDTO (UserResult userResult){
//        return new UpdateUserParam()
//                .setId(userResult.getId())
//                .setFullName(userResult.getFullName())
//                .setPhone(userResult.getPhone())
//                .setEmail(userResult.getEmail())
//                .setAddress(userResult.getAddress())
//                .setAvatarUrl(userResult.getAvatarUrl());
//    }

    public User toModel(CreateUserParam createUserParam) {
        return new User()
                .setRoleId(createUserParam.getRoleId())
                .setFullName(createUserParam.getFullName())
                .setPhone(createUserParam.getPhone())
                .setEmail(createUserParam.getEmail())
                .setAddress(createUserParam.getAddress())
                .setStatus(createUserParam.getStatus())
                .setUsername(createUserParam.getUsername())
                .setPassword(createUserParam.getPassword())
                .setAvatarUrl(createUserParam.getAvatarUrl());
    }

}
