package com.syntheticfeelingss.testApplication.Repository;

import com.syntheticfeelingss.testApplication.Domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByName(String name);
    List<Contact> findAll();

}
