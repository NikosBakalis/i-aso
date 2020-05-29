package ui.transfer_office;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DischargeNoteAndBillingScreen {
    public Button returnButton;
    public Button confirmButton;

    public DischargeNote note;
    public Billing bill;
    public Patient patient;
    public PatientFile pFile;
    public AdmissionTicket aTicket;

    public Label dischargeText;
    public Label billing;
    public Label amka;
    public Label firstName;
    public Label lastName;
    public Label hospital;
    public Label clinic;
    public Label duration;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();

    public void noteBilling(String patientFileId, String patientAmka) {

        note = iCRUDImpl.getDischargeNote(patientFileId);
        bill = iCRUDImpl.getBilling(patientFileId);
        pFile = iCRUDImpl.getPatientFile(patientFileId);
        aTicket = iCRUDImpl.getAdmissionTicket(patientFileId);
        patient = iCRUDImpl.getPatient(patientAmka);

        dischargeText.setText(note.getDischargeText());
        billing.setText(bill.getPrice().toString());
        amka.setText(patient.getAmka());
        firstName.setText(patient.getFirstName());
        lastName.setText(patient.getLastName());
        hospital.setText(pFile.getHospital());
        clinic.setText(note.getAdmissionClinic());

        Date admDate = aTicket.getCreatedAt();
        Date disDate = note.getCreatedAt();

        long diff = disDate.getTime() - admDate.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        int diffHours = (int) (diff / (60 * 60 * 1000));
        if (diffHours % 24 != 0) {
            diffDays += 1;
        }
        duration.setText(String.valueOf(diffDays));
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to discharge notes list");
        openScene("discharge_note_confirmation_screen.fxml");
        closeButtonAction();
    }

    public void onConfirmClick(ActionEvent actionEvent) throws IOException {
        int confirmationStatus = iCRUDImpl.setStageToFinal(note.getNoteId());
        if(confirmationStatus > 0) {
            System.out.println("Update Successful: Discharge Ticket Stage Updated!");
        }
        else {
            System.out.println("Update Failed: Discharge Ticket Stage NOT Updated!");
        }
        openScene("discharge_note_confirmation_screen.fxml");
        closeButtonAction();
    }
    private void openScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void closeButtonAction(){
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }
}
