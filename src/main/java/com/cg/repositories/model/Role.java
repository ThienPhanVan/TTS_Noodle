package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 45)
    private String code;

    @Column(name = "name", nullable = false, length = 45)
    private String name;


    public Role(long id) {
        this.id = id;
    }
}