package com.etiya.customerservice.service.abstracts;

import com.etiya.common.responses.CustomerResponse;

import java.util.UUID;

public interface CustomerService {

    CustomerResponse getById(UUID id);
}


