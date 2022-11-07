package com.cg.repositories;

import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

<<<<<<< HEAD

=======
    User findByRoleId(long id) ;

//    @Query(value = "SELECT new com.cg.dto.userDTO.UserResult (" +
//            "u.id, " +
//            "u.roleId, " +
//            "u.fullName, " +
//            "u.phone, " +
//            "u.email, " +
//            "u.address, " +
//            "u.avatarUrl " +
//            ") " +
//            "FROM User AS u " +
//            "WHERE u.fullName LIKE %?1% " +
//            "OR u.phone LIKE %?1% ")
//    List<UserResult> findUserByFullNameAndPhone(String keyword);
//
>>>>>>> development
}
