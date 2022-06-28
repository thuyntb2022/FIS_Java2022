package fis.test.test_final.service;

import fis.test.test_final.models.Customer;
import fis.test.test_final.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<CustomerDTO> findAll(Pageable pageable);
    CustomerDTO findById(Long id);
    CustomerDTO create(Customer customer);
    CustomerDTO update(Customer customer);
    CustomerDTO delete(Customer customer);
}
