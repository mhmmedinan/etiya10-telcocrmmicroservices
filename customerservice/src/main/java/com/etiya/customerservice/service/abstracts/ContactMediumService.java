package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.contactmediums.CreateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactmediums.CreatedContactMediumResponse;

public interface ContactMediumService {

    CreatedContactMediumResponse add(CreateContactMediumRequest request);
}
