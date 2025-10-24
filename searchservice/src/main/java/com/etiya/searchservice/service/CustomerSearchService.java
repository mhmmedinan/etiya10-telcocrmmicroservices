package com.etiya.searchservice.service;

import com.etiya.searchservice.domain.ContactMedium;
import com.etiya.searchservice.domain.CustomerSearch;

import java.util.List;

public interface CustomerSearchService {

    void add(CustomerSearch customerSearch);
    List<CustomerSearch> findAll();
    void delete(String id);
    List<CustomerSearch> searchAllFields(String keyword);
    void addContactMedium(ContactMedium contactMedium);
    List<CustomerSearch> searchDynamic(
            String id,
            String customerNumber,
            String nationalId,
            String firstName,
            String lastName,
            String value
    );
}
