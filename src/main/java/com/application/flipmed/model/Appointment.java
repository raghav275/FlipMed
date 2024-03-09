package com.application.flipmed.model;

import java.util.Date;
import java.util.UUID;

public class Appointment {

    private UUID id;

    private Doctor doctor;

    private Patient patient;

    private String time;

    private int fees;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Appointment(Doctor doctor, Patient patient, String time){
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
        this.id = UUID.randomUUID();
    }
}
