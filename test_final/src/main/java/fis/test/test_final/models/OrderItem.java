package fis.test.test_final.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_orderItem")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItem_id")
    private Long id;

    //    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(name = "product_quantity",nullable = false)
    private Long quantity;

    @Column(name = "orderItem_amount")
    private Double amount;

}
