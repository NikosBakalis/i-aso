package ui.transfer_office;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TemporaryAdmissionTicketScreen implements Initializable {
    public Button returnButton;
    public Button confirmButton;
    public Label labelAmka;
    public Label labelFirstName;
    public Label labelLastName;
    public Label labelId;
    public Label labelStage;
    public Label labelSourceClinic;
    public Label labelDestinationClinic;
    public TextField textFieldAmka;
    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldId;
    public TextField textFieldStage;
    public TextField textFieldSourceClinic;
    public TextField textFieldDestinationClinic;
    public Label labelAuthorizedBy;
    public TextField textFieldAuthorizedBy;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Transfer transfer = new Transfer();
    Patient patient = new Patient();
    AdmissionTicket admissionTicket = new AdmissionTicket();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldAmka.setText(transfer.getPatientAmka());
        textFieldFirstName.setText(patient.getFirstName());
        textFieldLastName.setText(patient.getLastName());
        textFieldId.setText(transfer.getId().toString());
        textFieldStage.setText(transfer.getStage());
        textFieldSourceClinic.setText(admissionTicket.getHostClinic());
        textFieldDestinationClinic.setText(admissionTicket.getAdmissionClinic());
        textFieldAuthorizedBy.setText(transfer.getAuthorisedBy());
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to admission tickets list");
        openScene("admission_ticket_confirmation_screen.fxml");
        closeButtonAction();
    }

    public void onConfirmClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Admission ticket confirmed");
        iCRUDImpl.finalConfirmationOfTemporaryAdmissionTicket(admissionTicket.getTicketId());
        openScene("admission_ticket_confirmation_screen.fxml");
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

    public void inspectAdmissionTicket(String fileId){

    }
}
