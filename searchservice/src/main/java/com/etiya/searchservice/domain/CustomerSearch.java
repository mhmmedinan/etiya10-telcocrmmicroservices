package com.etiya.searchservice.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.time.LocalDateTime;

@Document(indexName = "customersearch")
public class CustomerSearch {

    @Id
    private String id;

    private String customerNumber;
    private String firstName;

    private String lastName;

    private String nationalId;

    private LocalDateTime dateOfBirth;

    private String motherName;

    private String fatherName;

    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CustomerSearch(){}

    public CustomerSearch(String id, String customerNumber, String firstName,
                          String lastName, String nationalId, LocalDateTime dateOfBirth,
                          String motherName, String fatherName, String gender) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.gender = gender;
    }
}
