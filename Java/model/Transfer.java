package model;

import java.sql.Timestamp;

public class Transfer {
    private static Timestamp id;
    private static String authorisedBy, patientAmka, sourceClinic, destinationClinic, stage;

    public Timestamp getId() {
        return id;
    }

    public void setId(Timestamp id) {
        Transfer.id = id;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setAuthorisedBy(String authorisedBy) {
        Transfer.authorisedBy = authorisedBy;
    }

    public String getPatientAmka() {
        return patientAmka;
    }

    public void setPatientAmka(String patientAmka) {
        Transfer.patientAmka = patientAmka;
    }

    public String getSourceClinic() {
        return sourceClinic;
    }

    public void setSourceClinic(String sourceClinic) {
        Transfer.sourceClinic = sourceClinic;
    }

    public String getDestinationClinic() {
        return destinationClinic;
    }

    public void setDestinationClinic(String destinationClinic) {
        Transfer.destinationClinic = destinationClinic;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        Transfer.stage = stage;
    }
}
