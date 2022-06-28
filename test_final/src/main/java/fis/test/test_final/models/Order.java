package fis.test.test_final.models;
import fis.test.test_final.models.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tbl_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @Column(name="order_datetime",nullable = false)
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name="total_amount")
    private Double totalAmount;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
