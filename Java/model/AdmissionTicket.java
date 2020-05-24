package model;

import java.sql.Date;

public class AdmissionTicket {
    private static String ticketId, admissionClinic, hostClinic, patientChamber, patientBed, admissionText, stage;
    private static Date createdAt;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        AdmissionTicket.ticketId = ticketId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        AdmissionTicket.createdAt = createdAt;
    }

    public String getAdmissionClinic() {
        return admissionClinic;
    }

    public void setAdmissionClinic(String admissionClinic) {
        AdmissionTicket.admissionClinic = admissionClinic;
    }

    public String getHostClinic() {
        return hostClinic;
    }

    public void setHostClinic(String hostClinic) {
        AdmissionTicket.hostClinic = hostClinic;
    }

    public String getPatientChamber() {
        return patientChamber;
    }

    public void setPatientChamber(String patientChamber) {
        AdmissionTicket.patientChamber = patientChamber;
    }

    public String getPatientBed() {
        return patientBed;
    }

    public void setPatientBed(String patientBed) {
        AdmissionTicket.patientBed = patientBed;
    }

    public String getAdmissionText() {
        return admissionText;
    }

    public void setAdmissionText(String admissionText) {
        AdmissionTicket.admissionText = admissionText;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        AdmissionTicket.stage = stage;
    }
}
