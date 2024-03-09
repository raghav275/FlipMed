package com.application.flipmed.model;

import java.util.ArrayList;
import java.util.List;

public class Reception {
    private static Reception reception = null;

    private List<Doctor> doctorList = new ArrayList<>();
    private Reception(){

    }
    public static synchronized Reception getInstance()
    {
        if (reception == null)
            reception = new Reception();

        return reception;
    }
    public Appointment createAppointment(Doctor doctor, Patient patient, String time){
        if(checkAvailability(doctor,patient,time)){
            Appointment appointment = new Appointment(doctor,patient,time);
            System.out.println("Appointment created - "+appointment.getId().toString());
            doctor.updateSchedule(appointment);
            patient.updateSchedule(appointment);
            return appointment;
        }
        return null;
    }

    public void addDoctor(Doctor doctor){
        this.doctorList.add(doctor);
    }
    private boolean checkAvailability(Doctor doctor,Patient patient, String time){
        int th = Integer.parseInt(time.split("-")[0].split(":")[0]);
        return doctor.getAvailableSlots()[th - 9] && patient.getAvailableSlots()[th - 9];
    }
    public void searchDoctors(String specialisation){
        for(Doctor doctor : this.doctorList){
            if(doctor.getSpecialisation().equals(specialisation)){
                boolean[] slots = doctor.getAvailableSlots();
                for(int i=0;i<slots.length;i++){
                    if(slots[i]){
                        System.out.println(doctor.getName()+" - "+ (i+9)+"-"+(i+10));
                    }
                }
            }
        }
    }
}
