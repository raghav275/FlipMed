package com.application.flipmed;

import com.application.flipmed.model.Doctor;
import com.application.flipmed.model.Patient;
import com.application.flipmed.model.Reception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipmedDriver {
    private List<Doctor> doctorList;
    private List<Patient> patientList;

    public FlipmedDriver(){
        this.doctorList = new ArrayList<>();
        this.patientList = new ArrayList<>();
    }

    public void run() {
        Reception reception = Reception.getInstance();
        Doctor curious = new Doctor("Dr.Curious","Cardiologist");
        reception.addDoctor(curious);
        List<String> listOfAvailableSlots = new ArrayList<>();
        curious.setAvailableSlots(List.of("9:00-10:30"));
        listOfAvailableSlots.add("9:00-10:00");
        listOfAvailableSlots.add("12:00-13:00");
        listOfAvailableSlots.add("16:00-17:00");
        curious.setAvailableSlots(listOfAvailableSlots);
        Doctor dreadful = new Doctor("Dr.Dreadful","Dermatologist");
        reception.addDoctor(dreadful);
        dreadful.setAvailableSlots(List.of("9:00-10:00", "11:00-12:00", "13:00-14:00"));
        reception.searchDoctors("Cardiologist");
        Patient patient1 = new Patient("Patient1",22);

        reception.createAppointment(curious,patient1,"12:00-13:00");
        reception.searchDoctors("Cardiologist");
    }



}
