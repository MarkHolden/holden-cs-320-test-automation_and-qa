package com.holden.app.contacts;

import com.holden.app.exceptions.ArgumentException;
import com.holden.app.exceptions.ConflictException;
import com.holden.app.exceptions.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactServiceTests {
    /**
     * System Under Test.
     */
    private ContactService _sut;
    
    public ContactServiceTests() {
        _sut = new ContactService();
    }

    /**
     * The contact service shall be able to add contacts with a unique ID.
     */
    @Test
    public void addContact_ShouldAddContact_WhenIdIsUnique() throws ConflictException, NotFoundException {
        String id = "id";
        _sut.addContact(getValidContact(id));

        Assertions.assertNotNull(_sut.getContact(id));
    }

    /**
     * The contact service shall be able to add contacts with a unique ID.
     */
    @Test
    public void addContact_ShouldThrow_WhenIdIsNotUnique() throws ConflictException {
        _sut.addContact(getValidContact("id"));

        Assertions.assertThrows(ConflictException.class, () -> {
            _sut.addContact(getValidContact("id"));
        });
    }

    /**
     * The contact service shall be able to delete contacts per contact ID.
     */
    @Test
    public void deleteContact_ShouldRemoveContact_WhenIdExists() throws ConflictException, NotFoundException {
        String id = "id";
        _sut.addContact(getValidContact(id));

        _sut.deleteContact(id);
        Assertions.assertEquals(0, _sut.listContacts().size());
    }

    /**
     * The contact service shall be able to delete contacts per contact ID.
     */
    @Test
    public void deleteContact_ShouldThrow_WhenIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.deleteContact("id");
        });
    }

    /**
     * The contact service shall be able to delete contacts per contact ID.
     */
    @Test
    public void updateContact_ShouldUpdateContactFields_WhenIdExists() throws ConflictException, NotFoundException, ArgumentException {
        String id = "id"; 
        Contact original = getValidContact(id);
        _sut.addContact(original);
        String updatedFirstName = "firstName";
        String updatedLastName = "lastName";
        String updatedPhone = "1234567890";
        String updatedAddress = "address";
        Contact update = new Contact(id, updatedFirstName, updatedLastName, updatedPhone, updatedAddress);

        _sut.updateContact(update);

        Contact result = _sut.getContact(id);
        Assertions.assertEquals(updatedFirstName, result.getFirstName());
        Assertions.assertEquals(updatedLastName, result.getLastName());
        Assertions.assertEquals(updatedPhone, result.getPhone());
        Assertions.assertEquals(updatedAddress, result.getAddress());
    }

    /**
     * The contact service shall be able to delete contacts per contact ID.
     */
    @Test
    public void updateContact_ShouldThrow_WhenIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.updateContact(getValidContact("id"));
        });
    }

    @Test
    public void getContact_ShouldReturnContact_WhenIdExists() throws ConflictException, NotFoundException {
        String id = "AB1001";
        _sut.addContact(getValidContact(id));

        Assertions.assertNotNull(_sut.getContact(id));
    }

    @Test
    public void getContact_ShouldThrow_WhenIdDoesNotExist() throws NotFoundException {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.getContact("AB1001");
        });
    }

    @Test
    public void listContacts_ShouldReturnContactList() throws ConflictException {
        _sut.addContact(getValidContact("AB1001"));
        _sut.addContact(getValidContact("AB1002"));
        _sut.addContact(getValidContact("AB1003"));

        Assertions.assertEquals(3, _sut.listContacts().size());
    }

    @Test
    public void listContacts_ShouldReturnEmptyList_WhenThereAreNoContacts() {
        Assertions.assertEquals(0, _sut.listContacts().size());
    }

    private Contact getValidContact(String id) {
        try {
            return new Contact(id, "Emmett", "Brown", "5558675309", "1640 Riverside Drive");
        }
        catch (Exception e) {
            Assertions.assertFalse(true, "getValidContact should return valid contact.");
            return null;
        }
    }
}
