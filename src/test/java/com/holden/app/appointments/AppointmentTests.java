package com.holden.app.appointments;

import java.util.*;

import com.holden.app.exceptions.ArgumentException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class AppointmentTests {
    /**
     * System Under Test.
     */
    private Appointment _sut;
    private Calendar calendar = Calendar.getInstance();


    public AppointmentTests() throws ArgumentException {
        _sut = new Appointment("abcde12345", getDate(1), "Be there or be square.");
    }

    /**
     * The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters.
     * The appointment ID shall not be null and shall not be updatable.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenAppointmentId_IsInvalid(String appointmentId) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Appointment(appointmentId, getDate(1), "Be there or be square.");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Appointment Id"));
    }

    /**
     * The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters.
     * The appointment ID shall not be null and shall not be updatable.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetId_WhenAppointmentId_IsValid() throws ArgumentException {
        String id = "abcde12345";

        Appointment sut = new Appointment(id, getDate(1), "Be there or be square.");

        Assertions.assertEquals(id, sut.getId());
    }

    /**
     * The appointment object shall have a required appointment Date field.
     * The appointment Date field cannot be in the past.
     * The appointment Date field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldThrow_WhenDate_IsNull() throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Appointment("abcde12345", null, "Be there or be square.");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Date"));
    }

    /**
     * The appointment object shall have a required appointment Date field.
     * The appointment Date field cannot be in the past.
     * The appointment Date field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldThrow_WhenDate_IsInThePast() throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            new Appointment("abcde12345", getDate(-1), "Be there or be square.");
        });

        Assertions.assertTrue(thrown.getMessage().contains("Date"));
    }

    /**
     * The appointment object shall have a required appointment Date field.
     * The appointment Date field cannot be in the past.
     * The appointment Date field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetDate_WhenDate_IsValid() throws ArgumentException {
        Date date = getDate(1);
        
        Appointment sut = new Appointment("abcde12345", date, "Be there or be square");

        Assertions.assertEquals(date, sut.getDate());
    }

    /**
     * The appointment object shall have a required appointment Date field.
     * The appointment Date field cannot be in the past.
     * The appointment Date field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setDate_ShouldThrow_WhenDate_IsInThePast() throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setDate(getDate(-1));
        });

        Assertions.assertTrue(thrown.getMessage().contains("Date"));
    }

    /**
     * The appointment object shall have a required appointment Date field.
     * The appointment Date field cannot be in the past.
     * The appointment Date field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setDate_ShouldThrow_WhenDate_IsNull() throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setDate(null);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Date"));
    }

    /**
     * The appointment object shall have a required appointment Date field.
     * The appointment Date field cannot be in the past.
     * The appointment Date field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setDate_ShouldSetDate_WhenDate_IsValid() throws ArgumentException {
        Date date = getDate(1);
        
        _sut.setDate(date);

        Assertions.assertEquals(date, _sut.getDate());
    }

    /**
     * The appointment object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456abcde123456abcde123456abcde123456"})
    @NullAndEmptySource
    public void constructor_ShouldThrow_WhenDescription_IsInvalid(String description) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut = new Appointment("abcde12345", getDate(1), description);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Description"));
    }

    /**
     * The appointment object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void constructor_ShouldSetDescription_WhenDescription_IsValid() throws ArgumentException {
        String description = "Be there or be square";
        
        _sut = new Appointment("abcde12345",getDate(1), description);

        Assertions.assertEquals(description, _sut.getDescription());
    }

    /**
     * The appointment object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"abcde123456abcde123456abcde123456abcde123456abcde123456"})
    @NullAndEmptySource
    public void setDescription_ShouldThrow_WhenDescription_IsInvalid(String description) throws ArgumentException {
        ArgumentException thrown = Assertions.assertThrows(ArgumentException.class, () -> {
            _sut.setDescription(description);
        });

        Assertions.assertTrue(thrown.getMessage().contains("Description"));
    }

    /**
     * The appointment object shall have a required description String field that cannot be longer than 50 characters.
     * The description field shall not be null.
     * @throws ArgumentException
     */
    @Test
    public void setDescription_ShouldSetDescription_WhenDescription_IsValid() throws ArgumentException {
        String description = "Braun";
        
        _sut.setDescription(description);

        Assertions.assertEquals(description, _sut.getDescription());
    }

    private Date getDate(int minute) {
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }
}
