package com.holden.app.appointments;

import java.util.Date;

import com.holden.app.exceptions.ArgumentException;

public class Appointment {
    private final String id;
    private Date date;
    private String description;

    public Appointment(String appointmentId, Date date, String description) throws ArgumentException {
        if (appointmentId == null || appointmentId.length() < 1)
           throw new ArgumentException("Appointment Id must not be null or empty.");
        
        if (appointmentId.length() > 10)
            throw new ArgumentException("Appointment Id must be less than or equal to ten characters.");

        this.id = appointmentId;
        setDate(date);
        setDescription(description);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) throws ArgumentException {
        if (description == null || description.length() < 1)
            throw new ArgumentException("Description must not be null or empty.");

        if (description.length() > 50)
            throw new ArgumentException("Description must be less than or equal to 50 characters.");

        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) throws ArgumentException {
        if (date == null)
            throw new ArgumentException("Date must not be null.");

        if (date.before(new Date()))
            throw new ArgumentException("Date must be in the future.");

        this.date = date;
    }

    public String getId() {
        return this.id;
    }
}
