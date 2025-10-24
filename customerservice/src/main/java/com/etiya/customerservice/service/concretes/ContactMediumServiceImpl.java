package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.CreateContactMediumEvent;
import com.etiya.customerservice.domain.entities.ContactMedium;
import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.requests.contactmediums.CreateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactmediums.CreatedContactMediumResponse;
import com.etiya.customerservice.transport.kafka.producer.contactmedium.CreateContactMediumProducer;
import org.springframework.stereotype.Service;

@Service
public class ContactMediumServiceImpl implements ContactMediumService {

    private final ContactMediumRepository contactMediumRepository;
    private final CreateContactMediumProducer createContactMediumProducer;

    public ContactMediumServiceImpl(ContactMediumRepository contactMediumRepository, CreateContactMediumProducer createContactMediumProducer) {
        this.contactMediumRepository = contactMediumRepository;
        this.createContactMediumProducer = createContactMediumProducer;
    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest request) {
        ContactMedium contactMedium = new ContactMedium();
        contactMedium.setType(request.getType());
        contactMedium.setValue(request.getValue());
        contactMedium.setPrimary(request.isPrimary());
        Customer customer = new Customer();
        customer.setId(request.getCustomerId());
        contactMedium.setCustomer(customer);

        ContactMedium createdContact = contactMediumRepository.save(contactMedium);
        CreateContactMediumEvent event =
                new CreateContactMediumEvent(createdContact.getId().toString(),
                        createdContact.getCustomer().getId().toString(),
                        createdContact.getType().toString(),
                        createdContact.getValue(),
                        createdContact.isPrimary());

        createContactMediumProducer.produceContactMediumCreated(event);
        CreatedContactMediumResponse response = new CreatedContactMediumResponse();
        response.setId(createdContact.getId());
        return response;
    }
}
