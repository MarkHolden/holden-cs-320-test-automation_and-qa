package com.holden.app.appointments;

import java.util.*;

import com.holden.app.exceptions.*;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) throws ConflictException {
        if (appointments.stream().anyMatch(c -> c.getId().equals(appointment.getId())))
            throw new ConflictException(Appointment.class.getName(), appointment.getId());

        appointments.add(appointment);
    }

    public Appointment getAppointment(String id) throws NotFoundException {
        Optional<Appointment> appointment = appointments.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();

        if (!appointment.isPresent())
            throw new NotFoundException(Appointment.class.getName(), id);

        return appointment.get();
    }

    public void deleteAppointment(String id) throws NotFoundException {
        List<Appointment> toRemove = new ArrayList<>();
        appointments.stream()
            .filter(c -> c.getId().equals(id))
            .forEach(toRemove::add);

        if (toRemove.isEmpty())
            throw new NotFoundException(Appointment.class.getName(), id);

        appointments.removeAll(toRemove);
    }

    public List<Appointment> listAppointments() {
        return appointments;
    }

    public void updateAppointment(Appointment appointment) throws NotFoundException {
        if (appointments.stream().allMatch(c -> !c.getId().equals(appointment.getId())))
            throw new NotFoundException(Appointment.class.getName(), appointment.getId());

        appointments.stream()
            .filter(c -> c.getId().equals(appointment.getId()))
            .forEach(c -> {
                try {
                    c.setDate(appointment.getDate());
                    c.setDescription(appointment.getDescription());
                } catch (ArgumentException e) {
                    e.printStackTrace(); // make compiler happy.
                }
            });
    }
}
