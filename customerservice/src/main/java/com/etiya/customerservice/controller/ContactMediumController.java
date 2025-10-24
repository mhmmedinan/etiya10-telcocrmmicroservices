package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.requests.contactmediums.CreateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactmediums.CreatedContactMediumResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact-mediums/")
public class ContactMediumController {

    private final ContactMediumService contactMediumService;

    public ContactMediumController(ContactMediumService contactMediumService) {
        this.contactMediumService = contactMediumService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedContactMediumResponse createContactMedium(@RequestBody CreateContactMediumRequest request) {
        return contactMediumService.add(request);
    }
}
