package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,Integer> {
}
