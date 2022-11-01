package com.cg.model;

<<<<<<< HEAD:src/main/java/com/cg/model/UsersStatus.java
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> development:src/main/java/com/cg/model/CustomerStatus.java
@Entity
@Table(name = "customer_status")
public class CustomerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "code", nullable = false, length = 45)
    private String code;

<<<<<<< HEAD:src/main/java/com/cg/model/UsersStatus.java
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
=======
>>>>>>> development:src/main/java/com/cg/model/CustomerStatus.java

}