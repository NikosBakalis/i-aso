package model;

import javafx.beans.property.SimpleStringProperty;

public class InitialDoctorScreenListItem {
    private SimpleStringProperty amka, first_name, last_name, host_clinic, patient_chamber;

//    public InitialDoctorScreenListItem(String amka, String firstName, String lastName, String hostClinic, String chamber) {
//        this.amka = new SimpleStringProperty(amka);
//        this.firstName = new SimpleStringProperty(firstName);
//        this.lastName = new SimpleStringProperty(lastName);
//        this.hostClinic = new SimpleStringProperty(hostClinic);
//        this.chamber = new SimpleStringProperty(chamber);
//    }

    public String getAmka() {
        return amka.get();
    }
    public void setAmka(String amka) {
        this.amka = new SimpleStringProperty(amka);
    }

    public String getFirstName() {
        return first_name.get();
    }
    public void setFirstName(String first_name) {
        this.first_name = new SimpleStringProperty(first_name);
    }

    public String getLastName() {
        return last_name.get();
    }
    public void setLastName(String last_name) {
        this.last_name = new SimpleStringProperty(last_name);
    }

    public String getHostClinic() {
        return host_clinic.get();
    }
    public void setHostClinic(String host_clinic) {
        this.host_clinic = new SimpleStringProperty(host_clinic);
    }

    public String getPatientChamber() {
        return patient_chamber.get();
    }
    public void setPatientChamber(String patient_chamber) {
        this.patient_chamber = new SimpleStringProperty(patient_chamber);
    }
}
