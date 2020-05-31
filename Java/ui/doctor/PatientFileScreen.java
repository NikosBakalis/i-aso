package ui.doctor;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.lang.Math;
import java.util.Random;

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
    public TextArea diagnosisDataPatient;  // inside statusAndDiagnosisPane
    public Pane treatmentPane;
    public TextArea doctorTreatmentArea;  //inside treatmentPane
    public Button saveTreatmentButton;   //inside treatmentPane
    public TextArea treatmentDataPatient;  //inside treatmentPane
    public Pane dischargeNotePane;
    public TextArea dischargeText; //inside dischargeNotePane
    public ChoiceBox<String> hostClinic;   //inside dischargeNotePane
    public Button dischargeNoteSaveButton;  //inside dischargeNotePane
    public TextArea initialTextArea;
    public Pane admissionTicketPane;
    public ChoiceBox<String> clinics;
    public Button admissionTicketSaveButton;
    public TextArea admissionText;
    public VBox buttonVBox;

    Alert warning = new Alert(Alert.AlertType.WARNING);

    // first pane is the pane that contains all the buttons etc.. This pain never goes.
    // we use initial pane as the pane that only takes data from db. in this pane doctor is not supposed to make any changes.
    // so in order not to have many panes in "PatientInfo" , "BriefHistory", we use initial pane.
    // status and diagnosis pane only refers to status and diagnosis
    // treatment pne is the pane that refers to treatment
    // dischargeNotePane is a pane that refers to discharge note

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Patient patient = new Patient();
    PatientFile patientFile = new PatientFile();
    PatientFolder patientFolder = new PatientFolder();
    AdmissionTicket admissionTicket = new AdmissionTicket();
    User user = new User();
    Doctor doctor = new Doctor();

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

        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ: \t\t\t\t\t\t" + patient.getAmka());
        initialTextArea.appendText("\nΑΦΜ: \t\t\t\t\t\t" + patient.getAfm());
        initialTextArea.appendText("\nΌνομα: \t\t\t\t\t\t" + patient.getFirstName());
        initialTextArea.appendText("\nΕπώνυμο: \t\t\t\t\t" + patient.getLastName());
        initialTextArea.appendText("\nΗμ. Γέννησης: \t\t\t\t\t" + patient.getBirthDate());
        initialTextArea.appendText("\nΕθνικότητα: \t\t\t\t\t" + patient.getNationality());
        initialTextArea.appendText("\nΦύλο: \t\t\t\t\t\t" + patient.getGender());
        initialTextArea.appendText("\nΑσφάλεια: \t\t\t\t\t" + patient.getInsurance());
        initialTextArea.appendText("\nΠατρώνυμο: \t\t\t\t\t" + patient.getFatherFirstName());
        initialTextArea.appendText("\nΕπώνυμο Πατέρα: \t\t\t\t" + patient.getFatherLastName());
        initialTextArea.appendText("\nΌνομα Μητέρας: \t\t\t\t" + patient.getMotherFirstName());
        initialTextArea.appendText("\nΕπώνυμο Μητέρας: \t\t\t" + patient.getMotherLastName());
        initialTextArea.appendText("\nΌνομα Διεύθυνσης: \t\t\t" + patient.getFirstStreetName());
        initialTextArea.appendText("\nΑριθμός Διεύθυνσης: \t\t\t" + patient.getFirstStreetNumber());
        initialTextArea.appendText("\nΌνομα Διεύθυνσης (γραμμή 2): \t" + patient.getSecondStreetName());
        initialTextArea.appendText("\nΑριθμός Διεύθυνσης (γραμμή 2): \t" + patient.getSecondStreetNumber());
        initialTextArea.appendText("\nΤηλέφωνο Επικοινωνίας: \t\t" + patient.getPrimaryPhoneNumber());
        initialTextArea.appendText("\nEmail: \t\t\t\t\t\t" + patient.getEmainAddress());
    }

    public void onBriefHistoryClick(ActionEvent actionEvent) {
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show brief history");

        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ: \t\t\t\t" + patient.getAmka());
        initialTextArea.appendText("\nΌνομα: \t\t\t\t" + patient.getFirstName());
        initialTextArea.appendText("\nΕπώνυμο: \t\t\t" + patient.getLastName());
        initialTextArea.appendText("\nΧρόνιες Παθήσεις: \t\t" + patientFolder.getChronicDisease());
        initialTextArea.appendText("\nΑλλεργίες: \t\t\t" + patientFolder.getPatientAllergies());
        initialTextArea.appendText("\nΧειρουργία: \t\t\t" + patientFolder.getPatientSurgeries());
        initialTextArea.appendText("\nΟμάδα Αίματος: \t\t" + patientFolder.getBloodType());
        initialTextArea.appendText("\nHBV: \t\t\t\t" + patientFolder.getHBV());
        initialTextArea.appendText("\nHBC: \t\t\t\t" + patientFolder.getHBC());
    }
    // false because we are not supposed to do this.
    public void onDetailedHistoryClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        System.out.println("Show detailed history");
    }

    public void onAdmissionTicketClick(ActionEvent actionEvent) {
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show admission ticket");

        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ: \t\t\t\t\t" + patient.getAmka());
        initialTextArea.appendText("\nΌνομα: \t\t\t\t\t" + patient.getFirstName());
        initialTextArea.appendText("\nΕπώνυμο: \t\t\t\t" + patient.getLastName());
        initialTextArea.appendText("\nΗμερομηνία Εισαγωγής: \t" + admissionTicket.getCreatedAt());
        initialTextArea.appendText("\nΚλινική Εισαγωγής: \t\t" + admissionTicket.getAdmissionClinic());
        initialTextArea.appendText("\nΚλινική Υποδοχής: \t\t\t" + admissionTicket.getHostClinic());
        initialTextArea.appendText("\nΘάλαμος Ασθενή: \t\t\t" + admissionTicket.getPatientChamber());
        initialTextArea.appendText("\nΚρεβάτι Ασθενή: \t\t\t" + admissionTicket.getPatientChamber());
        initialTextArea.appendText("\nΚείμενο Εισιτηρίου: \t\t" + admissionTicket.getAdmissionText());
        initialTextArea.appendText("\nΣτάδιο: \t\t\t\t\t" + admissionTicket.getStage());
    }

    public void onStatusAndDiagnosisClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(true);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show status and diagnosis");
       if (patientFile.getDiagnosis() == null){
           diagnosisDataPatient.setText("Διάγνωση: " + " - "); }
       else {
           diagnosisDataPatient.setText("Διάγνωση: " + patientFile.getDiagnosis());
       }
    }

    public void onSaveStatusAndDiagnosisClick(ActionEvent actionEvent) {
        System.out.println("Save Status.");
        if (!doctorDiagnosisArea.getText().isEmpty()) {
            if (patientFile.getDiagnosis() == null) {
                iCRUDImpl.saveNewDiagnosis(doctorDiagnosisArea.getText(), patient.getAmka());
            } else {
                iCRUDImpl.saveNewDiagnosis(patientFile.getDiagnosis() + " + " + doctorDiagnosisArea.getText(), patient.getAmka());
            }
            iCRUDImpl.getPatientFile(patientFile.getFileId());
            doctorDiagnosisArea.clear();
            diagnosisDataPatient.setText("Διάγνωση: " + patientFile.getDiagnosis());
        } else {
            System.err.println("You cannot save an empty field!");
            warning.setTitle("Warning");
            warning.setHeaderText("Field is empty");
            warning.setContentText("Please fill in all fields!");
            warning.showAndWait();
        }
    }

    public void onTestsClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        treatmentPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show lab tests");
    }

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

        treatmentDataPatient.setEditable(false);

        if (patientFile.getTreatment() == null) {
            treatmentDataPatient.setText("Τωρινή Θεραπεία: " + " - ");
        } else {
            treatmentDataPatient.setText("Τωρινή Θεραπεία: " + patientFile.getTreatment());
        }
    }

    public void onSaveTreatmentClick(ActionEvent actionEvent) {
        if (!doctorTreatmentArea.getText().isEmpty()){
            if (patientFile.getTreatment() == null) {
                iCRUDImpl.saveNewTreatment(doctorTreatmentArea.getText(), patient.getAmka());
            } else {
                iCRUDImpl.saveNewTreatment(patientFile.getTreatment() + " + " + doctorTreatmentArea.getText(), patient.getAmka());
            }
            iCRUDImpl.getPatientFile(patientFile.getFileId());
            doctorTreatmentArea.clear();
            treatmentDataPatient.setText("Τωρινή Θεραπεία: " + patientFile.getTreatment());
        } else {
            System.err.println("You cannot save an empty field!");
            warning.setTitle("Warning");
            warning.setHeaderText("Field is empty");
            warning.setContentText("Please fill in all fields!");
            warning.showAndWait();
        }
    }

    public void onDischargeNoteClick(ActionEvent actionEvent) {
        System.out.println(admissionTicket.getStage());
        if (admissionTicket.getStage().equals("APPROVED")) {
            initialPane.setVisible(false);
            statusAndDiagnosisPane.setVisible(false);
            treatmentPane.setVisible(false);
            dischargeNotePane.setVisible(true);
            initialTextArea.setWrapText(true);
            System.out.println("Show discharge note");
            hostClinic.setItems(iCRUDImpl.getAllClinicNamesOfDoctor(user.getUsername(), doctor.getClinic()));
        } else {
            System.err.println("Stage not approved!");
            warning.setTitle("Warning");
            warning.setHeaderText("Wait");
            warning.setContentText("Please wait until ticket approved!");
            warning.showAndWait();
        }
    }

    public void onDischargeNoteSaveClick(ActionEvent actionEvent) throws IOException {
//        System.out.println(fileId);
        patientFile = iCRUDImpl.getFileIdFromAmkaAndHospital(patient.getAmka(), user.getHospital_afm());
        String newText;
        int max = 100000;
        int min = 100;
        double random = min + Math.random() * (max - min);
        float generatedFloat = (float) random;
        if(!dischargeText.getText().isEmpty()) {
            newText = dischargeText.getText();
            if (!hostClinic.getSelectionModel().isEmpty() && !hostClinic.getSelectionModel().getSelectedItem().equals("-")){
                newText += " + Ενδονοσοκομειακή μετακίνηση: " + hostClinic.getSelectionModel().getSelectedItem();
            }
            iCRUDImpl.insertDischargeNote(patientFile.getFileId(), newText, doctor.getClinic());
            iCRUDImpl.insertBilling(patientFile.getFileId(), generatedFloat);
            openScene("initial_doctor_screen.fxml");
            closeButtonAction();
        } else {
            System.err.println("You cannot save an empty field!");
            warning.setTitle("Warning");
            warning.setHeaderText("Field is empty");
            warning.setContentText("Please fill in all fields!");
            warning.showAndWait();
        }
    }

    public void onAdmissionTicketSaveClick(ActionEvent actionEvent) {
        String fileId = iCRUDImpl.insertPatientFile(patient.getAmka(), user.getHospital_afm(), user.getUsername());
        iCRUDImpl.getPatientFile(fileId);
        String newText;
        String hostClinic;
        if(!admissionText.getText().isEmpty()) {
            newText = admissionText.getText();
            if (!clinics.getSelectionModel().isEmpty() && !clinics.getSelectionModel().getSelectedItem().equals("-")){
                hostClinic = clinics.getSelectionModel().getSelectedItem();
            } else {
                hostClinic = doctor.getClinic();
            }
            iCRUDImpl.insertAdmissionTicket(fileId, doctor.getClinic(), hostClinic, newText);
            iCRUDImpl.getAdmissionTicket(fileId);
            buttonVBox.setVisible(true);
            admissionTicketPane.setVisible(false);
        } else {
            System.err.println("You cannot save an empty field!");
            warning.setTitle("Warning");
            warning.setHeaderText("Field is empty");
            warning.setContentText("Please fill in all fields!");
            warning.showAndWait();
        }
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
