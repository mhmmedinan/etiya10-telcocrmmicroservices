package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.IndividualCustomer;

public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer>{

    boolean existsByNationalId(String nationalId);
}
