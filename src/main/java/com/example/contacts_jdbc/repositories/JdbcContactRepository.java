package com.example.contacts_jdbc.repositories;

import com.example.contacts_jdbc.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcContactRepository implements ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findAll() {
        return jdbcTemplate.query("SELECT * FROM contacts",
                BeanPropertyRowMapper.newInstance(Contact.class));
    }

    @Override
    public Contact findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM contacts WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Contact.class), id);
    }

    @Override
    public int save(Contact contact) {
        return jdbcTemplate.update("INSERT INTO contacts (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)",
                contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
    }

    @Override
    public int update(Contact contact) {
        return jdbcTemplate.update("UPDATE contacts SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?",
                contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), contact.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM contacts WHERE id = ?", id);
    }
}