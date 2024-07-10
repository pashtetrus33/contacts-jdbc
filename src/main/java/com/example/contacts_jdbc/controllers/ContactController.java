package com.example.contacts_jdbc.controllers;

import com.example.contacts_jdbc.models.Contact;
import com.example.contacts_jdbc.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts";
    }

    @GetMapping("/new")
    public String showNewContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact_form";
    }


    @GetMapping("/edit/{id}")
    public String showEditContactForm(@PathVariable("id") Long id, Model model) {
        Contact contact = contactRepository.findById(id);
        model.addAttribute("contact", contact);
        return "contact_form";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute("contact") Contact contact) {
        if (contact.getId() == null) {
            contactRepository.save(contact);
        } else {
            contactRepository.update(contact);
        }

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        contactRepository.deleteById(id);
        return "redirect:/";
    }
}