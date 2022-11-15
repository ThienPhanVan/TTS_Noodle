package com.cg.repositories;


import com.cg.repositories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> getAllByRoleId(long id);

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
//    List<User> findUserByFullNameOrPhone(String keyword);

    boolean findUserByRoleId (Long roleId);

    @Query(value =
            "FROM User AS u " +
                    "WHERE u.fullName LIKE %:keyword% " +
                    "OR u.phone LIKE %:keyword% ")
    List<User> findAllByFullNameOrPhone(String keyword);



    @Query(value = "FROM User AS u WHERE u.roleId = 2 and u.fullName LIKE %?1% ")
    List<User> searchCustomer(String keyword);

    @Query(value = "FROM User AS u WHERE u.roleId = 3 and u.fullName LIKE %?1% ")
    List<User> searchSupplier(String keyword);

    @Query(value = "SELECT SUM(o.grandTotal) FROM  Order o where o.userId = :id")
    BigDecimal totalOrderOfUser(@Param("id") Long id);

}
