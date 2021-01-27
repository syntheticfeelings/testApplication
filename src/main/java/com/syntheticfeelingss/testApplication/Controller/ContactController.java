package com.syntheticfeelingss.testApplication.Controller;

import com.syntheticfeelingss.testApplication.Domain.Contact;
import com.syntheticfeelingss.testApplication.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getContactByName(@RequestParam String nameFilter) {
        return contactService.findByName(nameFilter);
    }

    @PostMapping("/{createContact}")
    public void addContact(@RequestParam String name){
        contactService.createContact(name);

    }

}
