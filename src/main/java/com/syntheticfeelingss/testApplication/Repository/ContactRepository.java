package com.syntheticfeelingss.testApplication.Repository;

import com.syntheticfeelingss.testApplication.Domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends CrudRepository<Contact, UUID> {
    List<Contact> findByName(String name);

}
