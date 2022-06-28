package fis.test.test_final.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "product_avaiable",nullable = false)
    private Long avaiable;
}
