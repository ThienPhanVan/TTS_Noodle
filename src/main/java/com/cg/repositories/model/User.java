package com.cg.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User {

    public User(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "address", nullable = false, length = 95)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false, length = 128)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "avatar_url", nullable = false)
    private String avatarUrl;

    @Column(name = "username", nullable = false)
    private String username;

    public User setRoleId(Long roleId) {
        this.roleId = roleId;
        this.role = new Role(roleId);
        return this;
    }

}