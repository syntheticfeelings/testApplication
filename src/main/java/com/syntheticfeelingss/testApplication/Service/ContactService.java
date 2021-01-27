package com.syntheticfeelingss.testApplication.Service;

import com.syntheticfeelingss.testApplication.Domain.Contact;
import com.syntheticfeelingss.testApplication.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(String name) {
        Contact c = new Contact();
        c.setName(name);
        return contactRepository.save(c);
    }

    public List<Contact> findByName(String name) {
        return contactRepository.findByName(name);
    }
}
