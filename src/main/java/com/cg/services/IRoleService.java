package com.cg.services;

import com.cg.dto.role.RoleResult;
import com.cg.repositories.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Optional<Role> findRoleCodeUserById(Long id);

    List<Role> findAllRole();
}
