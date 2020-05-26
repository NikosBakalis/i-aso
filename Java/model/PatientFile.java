package model;

import javafx.beans.property.StringProperty;

public class PatientFile {
    private static String patientAmka, fileId, hospital, clinic, diagnosis, treatment, labTests;

    public String getPatientAmka() {
        return patientAmka;
    }

    public void setPatientAmka(String patientAmka) {
        PatientFile.patientAmka = patientAmka;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        PatientFile.fileId = fileId;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        PatientFile.hospital = hospital;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        PatientFile.clinic = clinic;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        PatientFile.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        PatientFile.treatment = treatment;
    }

    public String getLabTests() {
        return labTests;
    }

    public void setLabTests(String labTests) {
        PatientFile.labTests = labTests;
    }
}
