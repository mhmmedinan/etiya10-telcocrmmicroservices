package com.etiya.customerservice.repository;

import com.etiya.customerservice.domain.entities.ContactMedium;
import com.etiya.customerservice.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactMediumRepository extends JpaRepository<ContactMedium, UUID> {
}
