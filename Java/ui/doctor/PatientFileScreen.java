package ui.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial doctor screen");
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();
    }

    public void onPatientInfoClick(ActionEvent actionEvent) {
        System.out.println("Show patient info");
    }

    public void onBriefHistoryClick(ActionEvent actionEvent) {
        System.out.println("Show brief history");
    }

    public void onDetailedHistoryClick(ActionEvent actionEvent) {
        System.out.println("Show detailed history");
    }

    public void onAdmissionTicketClick(ActionEvent actionEvent) {
        System.out.println("Show admission ticket");
    }

    public void onStatusAndDiagnosisClick(ActionEvent actionEvent) {
        System.out.println("Show status and diagnosis");
    }

    public void onTestsClick(ActionEvent actionEvent) {
        System.out.println("Show lab tests");
    }

    public void onTestResultsClick(ActionEvent actionEvent) {
        System.out.println("Show lab tests results");
    }

    public void onTreatmentClick(ActionEvent actionEvent) {
        System.out.println("Show treatment");
    }

    public void onDischargeNoteClick(ActionEvent actionEvent) {
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
}
