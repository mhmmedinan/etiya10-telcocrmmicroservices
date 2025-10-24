package com.etiya.customerservice.service.requests.contactmediums;

import com.etiya.customerservice.domain.enums.ContactMediumType;

import java.util.UUID;

public class CreateContactMediumRequest {
    private ContactMediumType type;
    private String value;

    private boolean isPrimary;

    private UUID customerId;

    public ContactMediumType getType() {
        return type;
    }

    public void setType(ContactMediumType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public CreateContactMediumRequest() {
    }


    public CreateContactMediumRequest(ContactMediumType type, String value, boolean isPrimary, UUID customerId) {
        this.type = type;
        this.value = value;
        this.isPrimary = isPrimary;
        this.customerId = customerId;
    }

}
