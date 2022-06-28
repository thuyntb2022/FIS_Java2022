package fis.test.test_final.dto;

import fis.test.test_final.models.Customer;
import fis.test.test_final.models.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id;

    private String name;

    private String mobile;

    private String address;

    private List<Order> orders;

    public class Mapper {
        public static CustomerDTO fromCustomer(Customer customer) {
            return CustomerDTO.builder().id(customer.getId())
                    .name(customer.getName())
                    .mobile(customer.getMobile())
                    .address((customer.getAddress()))
                    .build();
        }
    }
}
