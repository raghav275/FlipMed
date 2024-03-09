package com.application.flipmed.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Doctor {

    private UUID id;

    private String specialisation;

    private String name;

    private int rating;

    private List<Appointment> appointmentList;

    private boolean[] availableSlots = new boolean[12];

    public UUID getId() {
        return id;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public void setAvailableSlots(List<String> timeslots) {
        boolean[] slots = new boolean[12];

        for(String timeslot:timeslots){
            int th = Integer.parseInt(timeslot.split("-")[0].split(":")[0]);
            if(validateTime(timeslot)){
                slots[th-9] = true;
            }

        }
        for(int i=0;i<slots.length;i++){
            this.availableSlots[i] = this.availableSlots[i] | slots[i];
        }
    }

    public void updateAvailableSlot(String time,boolean isBooked){
        int th = Integer.parseInt(time.split("-")[0].split(":")[0]);
        this.availableSlots[th-9] = isBooked;
    }

    public Doctor(String name  ,String specialisation){
        this.id = UUID.randomUUID();
        this.rating = 0;
        this.name = name;
        this.specialisation = specialisation;
        Arrays.fill(availableSlots,false);
        this.appointmentList = new ArrayList<>();

    }

    private boolean validateTime(String timeslot){
        String[] time = timeslot.split("-");
        String[] from = time[0].split(":");
        String[] to = time[1].split(":");
        int fh = Integer.parseInt(from[0]);
        int fm = Integer.parseInt(from[1]);
        int th = Integer.parseInt(to[0]);
        int tm = Integer.parseInt(to[1]);
        if((th*60+tm)-(fh*60+fm)>60 && fh>=9 && th<=21){
            System.out.println(timeslot +" not allowed. Only 60 mins slots are allowed");
            return false;
        }
        return true;
    }

    public void updateSchedule(Appointment appointment){
        this.addToAppointmentList(appointment);
        this.updateAvailableSlot(appointment.getTime(),false);
    }

}
