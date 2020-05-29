package ui.clinic;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AdmissionTicketDetailsScreen implements Initializable {
    public Label clinicNameLabel;
    public Button returnButton;
    public Button saveButton;
    public TableView<AdmissionTicketDetailsScreenListItem> tableView;
    public TableColumn<AdmissionTicketDetailsScreenListItem, String> colFirstName;
    public TableColumn<AdmissionTicketDetailsScreenListItem, String> colLastName;
    public TableColumn<AdmissionTicketDetailsScreenListItem, Date> colBirthDate;
    public TableColumn<AdmissionTicketDetailsScreenListItem, String> colGender;
    public TableColumn<AdmissionTicketDetailsScreenListItem, String> colAdmissionText;
    public ComboBox chamberMenu;
    public ChoiceBox bedMenu;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    ClinicAgent clinicAgent = new ClinicAgent();
    AdmissionTicket admissionTicket = new AdmissionTicket();

    Alert error = new Alert(Alert.AlertType.ERROR);

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show pending admission tickets");
        openScene("pending_admission_ticket_screen.fxml");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAdmissionText.setCellValueFactory(new PropertyValueFactory<>("admissionText"));
    }

    public void setAdmissionTicketDetails(String amka, String ticketId) {
        System.out.println(amka + " " + ticketId);
        iCRUDImpl.getAdmissionTicket(ticketId);
        tableView.setItems(iCRUDImpl.getAdmissionTicketDetailsScreenListItems(amka, ticketId));
        chamberMenu.setItems(iCRUDImpl.getChambersWithFreeBeds(clinicAgent.getClinic(), user.getHospital_afm()));
    }

    public void onChamberSelect(ActionEvent actionEvent) {
        System.out.println("Chamber selected");
        bedMenu.setItems(iCRUDImpl.getFreeBedsOfChamber(clinicAgent.getClinic(), user.getHospital_afm(), chamberMenu.getValue().toString()));
    }

    public void onSaveClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to posts list screen");
        if ( bedMenu.getSelectionModel().isEmpty() ) {
            System.err.println("Null values!");
            error.setTitle("Error");
            error.setHeaderText("Empty fields");
            error.setContentText("Please fill all fields!");
            error.showAndWait();
        } else {
            iCRUDImpl.allocateBed(bedMenu.getValue().toString());
            iCRUDImpl.updateTicket(admissionTicket.getTicketId(), chamberMenu.getValue().toString(), bedMenu.getValue().toString());
        }
        openScene("initial_clinic_screen.fxml");
        closeButtonAction();
    }
}
