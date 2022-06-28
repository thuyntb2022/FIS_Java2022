package fis.test.test_final.dto;

import fis.test.test_final.models.Order;
import fis.test.test_final.models.OrderItem;
import fis.test.test_final.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private Long id;

    private Order order;

    private Product product;

    private Long quantity;

    private Double amount;

    public static class Mapper{
        public OrderItemDTO fromOrderItem(OrderItem orderItem) {
            return OrderItemDTO.builder()
                    .id(orderItem.getId())
                    .product(orderItem.getProduct())
                    .quantity(orderItem.getQuantity())
                    .amount(orderItem.getAmount())
                    .build();
        }
    }

}
