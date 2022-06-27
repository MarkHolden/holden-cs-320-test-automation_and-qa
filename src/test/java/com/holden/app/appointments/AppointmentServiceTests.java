package com.holden.app.appointments;

import java.util.*;

import com.holden.app.exceptions.*;

import org.junit.jupiter.api.*;

public class AppointmentServiceTests {
    /**
     * System Under Test.
     */
    private AppointmentService _sut;
    private Calendar calendar = Calendar.getInstance();
    
    public AppointmentServiceTests() {
        _sut = new AppointmentService();
    }

    /**
     * The appointment service shall be able to add appointments with a unique ID.
     */
    @Test
    public void addAppointment_ShouldAddAppointment_WhenIdIsUnique() throws ConflictException, NotFoundException {
        String id = "id";
        _sut.addAppointment(getValidAppointment(id));

        Assertions.assertNotNull(_sut.getAppointment(id));
    }

    /**
     * The appointment service shall be able to add appointments with a unique ID.
     */
    @Test
    public void addAppointment_ShouldThrow_WhenIdIsNotUnique() throws ConflictException {
        _sut.addAppointment(getValidAppointment("id"));

        Assertions.assertThrows(ConflictException.class, () -> {
            _sut.addAppointment(getValidAppointment("id"));
        });
    }

    /**
     * The appointment service shall be able to delete appointments per appointment ID.
     */
    @Test
    public void deleteAppointment_ShouldRemoveAppointment_WhenIdExists() throws ConflictException, NotFoundException {
        String id = "id";
        _sut.addAppointment(getValidAppointment(id));

        _sut.deleteAppointment(id);
        Assertions.assertEquals(0, _sut.listAppointments().size());
    }

    /**
     * The appointment service shall be able to delete appointments per appointment ID.
     */
    @Test
    public void deleteAppointment_ShouldThrow_WhenIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.deleteAppointment("id");
        });
    }

    /**
     * The appointment service shall be able to delete appointments per appointment ID.
     */
    @Test
    public void updateAppointment_ShouldUpdateAppointmentFields_WhenIdExists() throws ConflictException, NotFoundException, ArgumentException {
        String id = "id"; 
        Appointment original = getValidAppointment(id);
        _sut.addAppointment(original);
        Date updatedDate = getDate(6);
        String updatedDescription = "description";
        Appointment update = new Appointment(id, updatedDate, updatedDescription);

        _sut.updateAppointment(update);

        Appointment result = _sut.getAppointment(id);
        Assertions.assertEquals(updatedDate, result.getDate());
        Assertions.assertEquals(updatedDescription, result.getDescription());
    }

    /**
     * The appointment service shall be able to delete appointments per appointment ID.
     */
    @Test
    public void updateAppointment_ShouldThrow_WhenIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.updateAppointment(getValidAppointment("id"));
        });
    }

    @Test
    public void getAppointment_ShouldReturnAppointment_WhenIdExists() throws ConflictException, NotFoundException {
        String id = "AB1001";
        _sut.addAppointment(getValidAppointment(id));

        Assertions.assertNotNull(_sut.getAppointment(id));
    }

    @Test
    public void getAppointment_ShouldThrow_WhenIdDoesNotExist() throws NotFoundException {
        Assertions.assertThrows(NotFoundException.class, () -> {
            _sut.getAppointment("AB1001");
        });
    }

    @Test
    public void listAppointments_ShouldReturnAppointmentList() throws ConflictException {
        _sut.addAppointment(getValidAppointment("AB1001"));
        _sut.addAppointment(getValidAppointment("AB1002"));
        _sut.addAppointment(getValidAppointment("AB1003"));

        Assertions.assertEquals(3, _sut.listAppointments().size());
    }

    @Test
    public void listAppointments_ShouldReturnEmptyList_WhenThereAreNoAppointments() {
        Assertions.assertEquals(0, _sut.listAppointments().size());
    }

    private Appointment getValidAppointment(String id) {
        try {
            return new Appointment(id, getDate(15), "Do all of the things");
        }
        catch (Exception e) {
            Assertions.assertFalse(true, "getValidAppointment should return valid appointment.");
            return null;
        }
    }

    private Date getDate(int minutes) {
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }
}
