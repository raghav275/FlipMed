package com.application.flipmed.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Patient {

    private UUID id;
    private String name;

    private int age;

    private List<Appointment> appointmentList;

    private boolean[] availableSlots = new boolean[12];

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void addToAppointmentList(Appointment appointment) {
        this.appointmentList.add(appointment);
    }

    public boolean[] getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(String time) {
        int th = Integer.parseInt(time.split("-")[0].split(":")[0]);
        this.availableSlots[th-9] = true;
    }
    public void updateAvailableSlot(String time,boolean isAvailable){
        int th = Integer.parseInt(time.split("-")[0].split(":")[0]);
        this.availableSlots[th-9] = isAvailable;
    }

    public Patient(String name, int age){
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        Arrays.fill(availableSlots,true);
        this.appointmentList = new ArrayList<>();
    }

    public void updateSchedule(Appointment appointment){
        this.addToAppointmentList(appointment);
        this.updateAvailableSlot(appointment.getTime(),false);
    }

}
