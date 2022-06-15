package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.ApplicationException;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

    @Override
    public Customer findById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if(id == null) {
            throw new IllegalArgumentException("khong tim thay");
        } else {
            if (customerStore.getMapCustomer().containsKey(id)) {
                return (Customer) customerStore.getMapCustomer().get(id);
            } else {
                throw new CustomerNotFoundException("Khong tim thay");
            }
        }
    }

    @Override
    public Customer createCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        customerStore.getMapCustomer().values()
                .forEach(c -> {
                    if (c.getMobile().equals(customer.getMobile())) {
                        throw new DuplicateCustomerException(customer); //??
                    } else {
                        customerStore.insertOrUpdate(c); // chua co validate()
                        return;
                    }
                });
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        List <Customer> lst;
        lst = (List<Customer>) customerStore.getMapCustomer().values().stream()
                .filter(c -> c.getId().equals(customer.getId()));
        if (lst.isEmpty()) {
            throw new AppConstant("KHONG TON TAI");
        } else {
                lst.forEach(c -> {
                    if (c.getMobile().equals(customer.getMobile())) {
                        throw new AppConstant("DA TON TAI"); // ????
                    } else {
                        customerStore.insertOrUpdate(c); // chua co kiem tra dinh dang

                    }
                });
                return customer;
        }
    }

    @Override
    public void deleteCustomerById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        customerStore.getMapCustomer().values().stream().filter(c -> c.getStatus().equals("INACTIVE"))
                        .forEach(c-> {
                            if (c.getId().equals(id)) customerStore.deleteById(id);
                            return;
                        });

    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
       //Cai nay e coppy cua anh chua de tham khao :D
        return customerStore.findAll().stream().sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

}
