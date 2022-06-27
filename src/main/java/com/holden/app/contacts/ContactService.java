package com.holden.app.contacts;

import java.util.*;

import com.holden.app.exceptions.*;

public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) throws ConflictException {
        if (contacts.stream().anyMatch(c -> c.getId().equals(contact.getId())))
            throw new ConflictException(Contact.class.getName(), contact.getId());

        contacts.add(contact);
    }

    public Contact getContact(String id) throws NotFoundException {
        Optional<Contact> contact = contacts.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();

        if (!contact.isPresent())
            throw new NotFoundException(Contact.class.getName(), id);

        return contact.get();
    }

    public void deleteContact(String id) throws NotFoundException {
        List<Contact> toRemove = new ArrayList<>();
        contacts.stream()
            .filter(c -> c.getId().equals(id))
            .forEach(toRemove::add);

        if (toRemove.isEmpty())
            throw new NotFoundException(Contact.class.getName(), id);

        contacts.removeAll(toRemove);
    }

    public List<Contact> listContacts() {
        return contacts;
    }

    public void updateContact(Contact contact) throws NotFoundException {
        if (contacts.stream().allMatch(c -> !c.getId().equals(contact.getId())))
            throw new NotFoundException(Contact.class.getName(), contact.getId());

        contacts.stream()
            .filter(c -> c.getId().equals(contact.getId()))
            .forEach(c -> {
                try {
                    c.setFirstName(contact.getFirstName());
                    c.setLastName(contact.getLastName());
                    c.setPhone(contact.getPhone());
                    c.setAddress(contact.getAddress());
                } catch (ArgumentException e) {
                    e.printStackTrace(); // make compiler happy.
                }
            });
    }
}
