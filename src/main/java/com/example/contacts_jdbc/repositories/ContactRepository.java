package com.example.contacts_jdbc.repositories;

import com.example.contacts_jdbc.models.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> findAll();
    Contact findById(Long id);
    int save(Contact contact);
    int update(Contact contact);
    int deleteById(Long id);
}