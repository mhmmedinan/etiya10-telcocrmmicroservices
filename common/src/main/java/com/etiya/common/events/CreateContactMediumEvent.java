package com.etiya.common.events;


public record CreateContactMediumEvent (
        String contactMediumId,
        String customerId,
        String type,
        String value,
        boolean isPrimary) {}