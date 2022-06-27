package com.holden.app.contacts;

import com.holden.app.exceptions.ArgumentException;
import java.util.regex.*;

public class Contact {
    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) throws ArgumentException {
        if (contactId == null || contactId.length() < 1)
           throw new ArgumentException("Contact Id must not be null or empty.");
        
        if (contactId.length() > 10)
            throw new ArgumentException("Contact Id must be less than or equal to ten characters.");

        this.id = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) throws ArgumentException {
        if (address == null || address.length() < 1)
            throw new ArgumentException("Address must not be null or empty.");

        if (address.length() > 30)
            throw new ArgumentException("Address must be less than or equal to 30 characters.");

        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) throws ArgumentException {
        if (phone == null || !Pattern.matches("\\d{10}", phone))
            throw new ArgumentException("Phone must be ten digits.");

        this.phone = phone;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) throws ArgumentException {
        if (lastName == null || lastName.length() < 1)
            throw new ArgumentException("Last Name must not be null or empty.");

        if (lastName.length() > 10)
            throw new ArgumentException("Last Name must be less than or equal to ten characters.");

        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) throws ArgumentException {
        if (firstName == null || firstName.length() < 1)
            throw new ArgumentException("First Name must not be null or empty.");

        if (firstName.length() > 10)
            throw new ArgumentException("First Name must be less than or equal to ten characters.");

        this.firstName = firstName;
    }

    public String getId() {
        return this.id;
    }
}
