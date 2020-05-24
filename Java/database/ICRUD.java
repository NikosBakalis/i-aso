package database;

import model.*;

public interface ICRUD {
    Hospital getHospital(String afm);
    Clinic getClinic(String name, String hospital_afm);
    Patient getPatient(String amka);
    // PatientFolder
    // PatientFile
    // Chamber
    // Bed
    // AdmissionTicket
    // DischargeNote
    // Billing
    User getUser(String username);
    Doctor getDoctor(String username);
    // Transfer
    // PatientTransferOffice
    // TransferOfficeAgent
    Lab getLab(String hospital_afm, String name);
    // LabAgent
    ClinicAgent getClinicAgent(String username);
}
