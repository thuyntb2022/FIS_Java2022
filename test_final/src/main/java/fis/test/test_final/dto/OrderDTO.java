package fis.test.test_final.dto;

import fis.test.test_final.models.Order;
import fis.test.test_final.models.OrderItem;
import fis.test.test_final.models.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO{
    private Long id;

    private LocalDateTime orderDateTime;

    private Long customerId;

    private List<OrderItem> orderItems;

    private Double totalAmount;

    private OrderStatus status;

    public static class Mapper {
        public static OrderDTO fromOrder(Order order) {
            return OrderDTO.builder().id(order.getId())
                    .orderDateTime(order.getOrderDateTime())
                    .orderItems(order.getOrderItems())
                    .customerId(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .status(order.getStatus())
                    .build();
        }
    }
}
