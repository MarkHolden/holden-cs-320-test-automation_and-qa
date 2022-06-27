package com.holden.app.contacts;

import com.holden.app.exceptions.ArgumentException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ContactTests {
    /**
     * System Under Test.
     */
    private Contact _sut;

    public ContactTests() throws ArgumentException {
        _sut = new Contact("abcde12345", "Emmett", "Brown", "5558675309", "1640 Riverside Drive");
    }

    /**
     * The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
     * The contact ID shall not be null and shall not be updatable.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenContactId_IsInvalid(String contactId) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Contact(contactId, "Emmett", "Brown", "5558675309", "1640 Riverside Drive");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Contact Id"));
    }

    /**
     * The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
     * The contact ID shall not be null and shall not be updatable.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetId_WhenContactId_IsValid() throws ArgumentException {
        String id = "abcde12345";

        Contact sut = new Contact(id, "Emmett", "Brown", "5558675309", "1640 Riverside Drive");

        Assertions.assertEquals(id, sut.getId());
    }

    /**
     * The contact object shall have a required firstName String field that cannot be longer than 10 characters.
     * The firstName field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenFirstName_IsInvalid(String firstName) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Contact("abcde12345", firstName, "Brown", "5558675309", "1640 Riverside Drive");
        });

        Assertions.assertTrue(thrown.getMessage().contains("First Name"));
    }

    /**
     * The contact object shall have a required firstName String field that cannot be longer than 10 characters.
     * The firstName field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetFirstName_WhenFirstName_IsValid() throws ArgumentException {
        String firstName = "Emmett";
        
        Contact sut = new Contact("abcde12345", firstName, "Brown", "5558675309", "1640 Riverside Drive");

        Assertions.assertEquals(firstName, sut.getFirstName());
    }

    /**
     * The contact object shall have a required firstName String field that cannot be longer than 10 characters.
     * The firstName field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void setFirstName_ShouldThrow_WhenFirstName_IsInvalid(String firstName) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setFirstName(firstName);
        });

        Assertions.assertTrue(thrown.getMessage().contains("First Name"));
    }

    /**
     * The contact object shall have a required firstName String field that cannot be longer than 10 characters.
     * The firstName field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setFirstName_ShouldSetFirstName_WhenFirstName_IsValid() throws ArgumentException {
        String firstName = "Doc";
        
        _sut.setFirstName(firstName);

        Assertions.assertEquals(firstName, _sut.getFirstName());
    }

    /**
     * The contact object shall have a required lastName String field that cannot be longer than 10 characters.
     * The lastName field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenLastName_IsInvalid(String firstName) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut = new Contact("abcde12345", "Emmett", firstName, "5558675309", "1640 Riverside Drive");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Last Name"));
    }

    /**
     * The contact object shall have a required lastName String field that cannot be longer than 10 characters.
     * The lastName field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetLastName_WhenLastName_IsValid() throws ArgumentException {
        String lastName = "Brown";
        
        _sut = new Contact("abcde12345", "Emmett", lastName, "5558675309", "1640 Riverside Drive");

        Assertions.assertEquals(lastName, _sut.getLastName());
    }

    /**
     * The contact object shall have a required lastName String field that cannot be longer than 10 characters.
     * The lastName field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void setLastName_ShouldThrow_WhenLastName_IsInvalid(String lastName) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setLastName(lastName);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Last Name"));
    }

    /**
     * The contact object shall have a required lastName String field that cannot be longer than 10 characters.
     * The lastName field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setLastName_ShouldSetLastName_WhenLastName_IsValid() throws ArgumentException {
        String lastName = "Braun";
        
        _sut.setLastName(lastName);

        Assertions.assertEquals(lastName, _sut.getLastName());
    }

    /**
     * The contact object shall have a required phone String field that must be exactly 10 digits.
     * The phone field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456", "123456789", "1234567891011" })
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenPhone_IsInvalid(String phone) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Contact("abcde12345", "Emmett", "Brown", phone, "1640 Riverside Drive");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Phone"));
    }

    /**
     * The contact object shall have a required phone String field that must be exactly 10 digits.
     * The phone field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetPhone_WhenPhone_IsValid() throws ArgumentException {
        String phone = "5558675309";
        
        Contact sut = new Contact("abcde12345", "Emmett", "Brown", phone, "1640 Riverside Drive");

        Assertions.assertEquals(phone, sut.getPhone());
    }

    /**
     * The contact object shall have a required phone String field that must be exactly 10 digits.
     * The phone field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456", "123456789", "1234567891011" })
    @NullAndEmptySource
    public void setPhone_ShouldThrow_WhenPhone_IsInvalid(String phone) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setPhone(phone);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Phone"));
    }

    /**
     * The contact object shall have a required phone String field that must be exactly 10 digits.
     * The phone field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setPhone_ShouldSetPhone_WhenPhone_IsValid() throws ArgumentException {
        String phone = "1234567890";
        
        _sut.setPhone(phone);

        Assertions.assertEquals(phone, _sut.getPhone());
    }

    /**
     * The contact object shall have a required address field that must be no longer than 30 characters.
     * The address field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenAddress_IsInvalid(String address) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Contact("abcde12345", "Emmett", "Brown", "5558675309", address);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Address"));
    }

    /**
     * The contact object shall have a required address field that must be no longer than 30 characters.
     * The address field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetAddress_WhenAddress_IsValid() throws ArgumentException {
        String address = "1640 Riverside Drive";
        
        Contact sut = new Contact("abcde12345", "Emmett", "Brown", "5558675309", address);

        Assertions.assertEquals(address, sut.getAddress());
    }

    /**
     * The contact object shall have a required address field that must be no longer than 30 characters.
     * The address field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456abcde123456" })
    @NullAndEmptySource
    public void setAddress_ShouldThrow_WhenAddress_IsInvalid(String address) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setAddress(address);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Address"));
    }

    /**
     * The contact object shall have a required address field that must be no longer than 30 characters.
     * The address field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setAddress_ShouldSetAddress_WhenAddress_IsValid() throws ArgumentException {
        String address = "1234567890";
        
        _sut.setAddress(address);

        Assertions.assertEquals(address, _sut.getAddress());
    }
}
