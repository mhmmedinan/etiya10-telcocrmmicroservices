package com.etiya.customerservice.service.abstracts;

import com.etiya.common.responses.CustomerResponse;
import com.etiya.customerservice.service.requests.individualcustomers.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.individualcustomers.CreatedIndividualCustomerResponse;

import java.util.UUID;

public interface IndividualCustomerService {

    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest request);

    CustomerResponse getById(UUID id);
}
