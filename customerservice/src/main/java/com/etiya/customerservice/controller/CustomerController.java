package com.etiya.customerservice.controller;

import com.etiya.common.responses.CustomerResponse;
import com.etiya.customerservice.service.abstracts.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable UUID id){
        return customerService.getById(id);
    }
}
