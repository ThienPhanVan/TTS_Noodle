package com.cg.services;

import com.cg.repositories.model.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findRoleCodeUserById(Long id);
}
