package com.syntheticfeelingss.testApplication.Service;

import com.syntheticfeelingss.testApplication.DTO.ContactDTO;
import com.syntheticfeelingss.testApplication.Domain.Contact;
import com.syntheticfeelingss.testApplication.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(String name) {
        Contact c = new Contact();
        c.setName(name);
        return contactRepository.save(c);
    }

    public List<ContactDTO> findByName(String nameFilter) {
        Pattern REGEX = Pattern.compile(nameFilter);

        List<Contact> all = contactRepository.findAll();
        List<ContactDTO> dtos = new ArrayList<>();

        for (Contact contact : all) {
            if (REGEX.matcher(contact.getName()).matches()) {
                dtos.add(convertToContactDto(contact));
            }
        }
        return dtos;
    }

    private ContactDTO convertToContactDto(Contact c) {
        ContactDTO dto = new ContactDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        return dto;
    }
}
