package com.etiya.searchservice.service;

import com.etiya.searchservice.domain.ContactMedium;
import com.etiya.searchservice.domain.CustomerSearch;
import com.etiya.searchservice.repository.CustomerSearchRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerSearchServiceImpl implements CustomerSearchService{

    private final CustomerSearchRepository customerSearchRepository;

    public CustomerSearchServiceImpl(CustomerSearchRepository customerSearchRepository) {
        this.customerSearchRepository = customerSearchRepository;
    }

    @Override
    public void add(CustomerSearch customerSearch) {
         customerSearchRepository.save(customerSearch);
    }

    @Override
    public List<CustomerSearch> findAll() {
        return StreamSupport.stream(customerSearchRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        customerSearchRepository.deleteById(id);
    }

    @Override
    public List<CustomerSearch> searchAllFields(String keyword) {
        return customerSearchRepository.searchAllFields(keyword);
    }

    @Override
    public void addContactMedium(ContactMedium contactMedium) {
        var customerSearch = customerSearchRepository.findById(contactMedium.getCustomerId()).orElseThrow();
        customerSearch.getContactMediums().removeIf(a -> Objects.equals(a.getContactMediumId(), contactMedium.getContactMediumId())); // idempotent

        customerSearch.getContactMediums().add(contactMedium);
        customerSearchRepository.save(customerSearch);
    }

    @Override
    public List<CustomerSearch> searchDynamic(String id, String customerNumber, String nationalId, String firstName, String lastName, String value) {
        return customerSearchRepository.searchDynamic(id,customerNumber,nationalId,firstName,lastName,value);
    }
}
