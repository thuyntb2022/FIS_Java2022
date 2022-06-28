package fis.test.test_final.models;



import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tbl_customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;

    @Column(name="name",nullable = false, length = 100)
    private String name;

    @Column(name="mobile",nullable = false,unique = true, length = 10)
    private String mobile;

    @Column(name="address",nullable = false, length = 100)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
