package com.etiya.customerservice.service.concretes;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.responses.CustomerResponse;
import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.service.abstracts.CustomerService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository<Customer> customerRepository;

    public CustomerServiceImpl(CustomerRepository<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse getById(UUID id) {
        return customerRepository.findById(id).stream().map(this::mapToResponse).findFirst().orElseThrow(()->new BusinessException("Customer Not Found"));
    }

    private CustomerResponse mapToResponse(Customer customer){
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        return response;
    }
}
