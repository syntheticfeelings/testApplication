package com.syntheticfeelingss.testApplication.Service;


import com.syntheticfeelingss.testApplication.Domain.Contact;
import com.syntheticfeelingss.testApplication.Repository.ContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(statements = "delete from contact", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ContactServiceTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

    @Test
    public void testCreateContact() {
        Contact read = contactService.createContact("Matthew");
        Assert.assertNotNull(read.getId());

        Contact contact = contactRepository.findById(read.getId()).get();
        Assertions.assertThat(read).isEqualTo(contact);

    }

    @Test
    public void testFindByName() {
        Contact c = new Contact();
        c.setName("Matthew");

        Contact create = contactService.createContact(c.getName());
        List<Contact> read = contactService.findByName("Matthew");

        List<Contact> contact = contactService.findByName(read.get(0).getName());
        Assertions.assertThat(read).isEqualTo(contact);

    }
}
