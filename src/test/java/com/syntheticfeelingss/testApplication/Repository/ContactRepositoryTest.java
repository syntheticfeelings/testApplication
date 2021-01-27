package com.syntheticfeelingss.testApplication.Repository;

import com.syntheticfeelingss.testApplication.Domain.Contact;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(statements = "delete from contact", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testSave() {
        Contact c = new Contact();
        c = contactRepository.save(c);
        assertNotNull(c.getId());
        assertTrue(contactRepository.findById(c.getId()).isPresent());
    }

    @Test
    public void testFindByName() {
        Contact create = new Contact();
        create.setName("Matthew");
        create = contactRepository.save(create);
        assertNotNull(create.getName());

        List<Contact> read = contactRepository.findByName(create.getName());
        Assertions.assertThat(create).isEqualTo(read.get(0));


    }
}
