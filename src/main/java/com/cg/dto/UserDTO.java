package com.cg.dto;

import com.cg.repositories.model.Role;
import com.cg.repositories.model.User;
import com.cg.repositories.model.UsersStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    private Role role;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private UsersStatus status;

    private String username;

    private String password;

    private String urlImage;

    public User toUser(){
        return new User()
                .setId(id)
                .setRole(role.toRole())
                .setFullName(fullName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setUrlImage(urlImage);

    }

}
