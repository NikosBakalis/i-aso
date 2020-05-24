package database;

import model.*;

public interface ICRUD {
    Hospital getHospital(String afm);
    Clinic getClinic(String name, String hospital_afm);
    Patient getPatient(String amka);
    PatientFolder getPatientFolder(String patient_amka);
    PatientFile getPatientFile(String file_id);
    Chamber getChamber(String id);
    Bed getBed(String number);
    AdmissionTicket getAdmissionTicket(String ticket_id);
    DischargeNote getDischargeNote(String note_id);
    Billing getBilling(String billing_id);
    User getUser(String username);
    Doctor getDoctor(String username);
    // Transfer
    // PatientTransferOffice
    // TransferOfficeAgent
    Lab getLab(String hospital_afm, String name);
    // LabAgent
    ClinicAgent getClinicAgent(String username);
    // ClinicAgentPost
}
