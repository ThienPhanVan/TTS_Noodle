package com.cg.repositories;

import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findByRoleId(long id) ;

    User findUserById(long id);

}
