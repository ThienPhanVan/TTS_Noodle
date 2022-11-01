package com.cg.model;

import javax.persistence.*;
import java.math.BigDecimal;

<<<<<<< HEAD
=======
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> development
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "grand_total", nullable = false, precision = 12)
    private BigDecimal grandTotal;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "status_id", nullable = false)
    private Integer statusId;


 

}