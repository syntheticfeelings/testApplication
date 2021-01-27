package com.syntheticfeelingss.testApplication.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syntheticfeelingss.testApplication.Service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContactService contactService;

    @Test
    public void testAddContact() {
//        Contact create = new Contact();
//        contactService.createContact(create.getName());
//        Contact read = contactService.findByName(create.getName()).get(0);
    }
}
