package com.cg.repositories;

import com.cg.repositories.model.Role;
import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(long id) ;
}
