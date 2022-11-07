package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "users")

public class User {
    public User(long roleId) {
         this.role = new Role(this.roleId = roleId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_id", insertable = false, updatable = false)
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "full_name", length = 128)
    private String fullName;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address", length = 95)
    private String address;

    private UserStatus status;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "url_images")
    private String urlImage;
}