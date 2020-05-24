package model;

import java.sql.Date;

public class DischargeNote {
    private static String noteId, dischargeText, admissionClinic, stage;
    private static Date createdAt;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        DischargeNote.noteId = noteId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        DischargeNote.createdAt = createdAt;
    }

    public String getDischargeText() {
        return dischargeText;
    }

    public void setDischargeText(String dischargeText) {
        DischargeNote.dischargeText = dischargeText;
    }

    public String getAdmissionClinic() {
        return admissionClinic;
    }

    public void setAdmissionClinic(String admissionClinic) {
        DischargeNote.admissionClinic = admissionClinic;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        DischargeNote.stage = stage;
    }
}
