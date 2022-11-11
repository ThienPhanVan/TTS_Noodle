package com.cg.services.impl;

import com.cg.repositories.RoleRepository;
import com.cg.repositories.model.Role;
import com.cg.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findRoleCodeUserById(Long id) {
        return roleRepository.findRoleCodeUserById(id);
    }
}
