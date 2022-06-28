package fis.test.test_final.dto;

import fis.test.test_final.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    private String name;

    private Double price;

    private Long avaiable;

    public static class Mapper{
        public ProductDTO fromProduct(Product product) {
            return ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .avaiable(product.getAvaiable())
                    .build();
        }
    }
}
