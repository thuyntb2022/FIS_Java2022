package fis.test.test_final.service.impl;

import fis.test.test_final.models.Customer;
import fis.test.test_final.dto.CustomerDTO;
import fis.test.test_final.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CustomerDTO findById(Long id) {
        return null;
    }

    @Override
    public CustomerDTO create(Customer customer) {
        return null;
    }

    @Override
    public CustomerDTO update(Customer customer) {
        return null;
    }

    @Override
    public CustomerDTO delete(Customer customer) {
        return null;
    }
}
