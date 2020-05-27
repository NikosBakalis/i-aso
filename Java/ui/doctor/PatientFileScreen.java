package ui.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientFileScreen {
    public Button returnButton;
    public Button patientInfoButton;
    public Button briefHistoryButton;
    public Button detailedHistoryButton;
    public Button admissionTicketButton;
    public Button statusAndDiagnosisButton;
    public Button testsButton;
    public Button testResultsButton;
    public Button treatmentButton;
    public Button dischargeNoteButton;
    public ScrollPane initialPane;
    public Pane firstPane;
    public Pane statusAndDiagnosisPane;
    public ScrollPane infoDataPatient; // inside statusAndDiagnosisPane
    public TextArea doctorDiagnosisArea; // inside statusAndDiagnosisPane
    public Button saveStatusAndDiagnosisButton; // inside statusAndDiagnosisPane
    public Pane treatmentPane;
    public ScrollPane treatmentDataPatient;  //inside treatmentPane
    public TextArea doctorTreatmentArea;  //inside treatmentPane
    public Button saveTreatmentButton;   //inside treatmentPane
    public Pane dischargeNotePane;
    public TextArea dischargeText; //inside dischargeNotePane
    public ComboBox hostClinic;   //inside dischargeNotePane
    public Button dischargeNoteSaveButton;  //inside dischargeNotePane

    // first pane is the pane that contains all the buttons etc.. This pain never goes.
    // we use initial pane as the pane that only takes data from db. in this pane doctor is not supposed to make any changes.
    // so in order not to have many panes in "PatientInfo" , "BriefHistory", we use initial pane.
    // status and diagnosis pane only refers to status and diagnosis
    //treatment pne is the pane that refers to treatment
    // dischargeNotePane is a pane that refers to discharge note

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial doctor screen");
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();
    }

    public void onPatientInfoClick(ActionEvent actionEvent) {
        System.out.println("Show patient info");
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
    }

    public void onBriefHistoryClick(ActionEvent actionEvent) {
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show brief history");
    }
   // false because we are not supposed to do this.
    public void onDetailedHistoryClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show detailed history");
    }
// in this phase doctor can only see the admission ticket. Not change it
    public void onAdmissionTicketClick(ActionEvent actionEvent) {
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show admission ticket");
    }

    public void onStatusAndDiagnosisClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(true);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show status and diagnosis");
    }
    // false because we are not supposed to do this.
    public void onTestsClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        treatmentPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show lab tests");
    }
    // false because we are not supposed to do this.
    public void onTestResultsClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        System.out.println("Show lab tests results");
    }

    public void onTreatmentClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(true);
        dischargeNotePane.setVisible(false);
        System.out.println("Show treatment");
    }

    public void onDischargeNoteClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(true);
        System.out.println("Show discharge note");
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

    // inside statusAndDiagnosisPane
    public void onSaveStatusAndDignosisClick(ActionEvent actionEvent) {
    }
    //inside treatmentPane
    public void onSaveTreatmentClick(ActionEvent actionEvent) {
    }

    public void onHostClinicClick(ActionEvent actionEvent) throws IOException {
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();

    }
    public void onDischargeNoteSaveClick(ActionEvent actionEvent) throws IOException {
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();
    }
}
