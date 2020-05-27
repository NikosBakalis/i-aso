package ui.doctor;

import database.ICRUDImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Doctor;
import model.InitialDoctorScreenListItem;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitialDoctorScreen implements Initializable {
    public Label titleLabelId;
    public Button logoutButton;
    public Button newPatientButton;
    public Button profileButton;
    public AnchorPane patientFileTable;
    public TableView<InitialDoctorScreenListItem> tableView;
    public TableColumn<InitialDoctorScreenListItem, SimpleStringProperty> colAmka;
    public TableColumn<InitialDoctorScreenListItem, SimpleStringProperty> colFirstName;
    public TableColumn<InitialDoctorScreenListItem, SimpleStringProperty> colLastName;
    public TableColumn<InitialDoctorScreenListItem, SimpleStringProperty> colHostClinic;
    public TableColumn<InitialDoctorScreenListItem, SimpleStringProperty> colChamber;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    Doctor doctor = new Doctor();

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Doctor log out");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onNewPatientClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Add new patient");
        openScene("new_patient_info_screen.fxml");
        closeButtonAction();
    }

    public void onProfileClick(ActionEvent actionEvent) {
        System.out.println("Doctor profile");
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
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        tableView = new TableView<>();
//        colAmka = new TableColumn<>("ΑΜΚΑ");
//        colFirstName = new TableColumn<>("ΟΝΟΜΑ");
//        colLastName = new TableColumn<>("ΕΠΩΝΥΜΟ");
//        colHostClinic = new TableColumn<>("ΚΛΙΝΙΚΗ ΦΙΛΟΞΕΝΙΑΣ");
//        colChamber = new TableColumn<>("ΘΑΛΑΜΟΣ");

        colAmka.setCellValueFactory(new PropertyValueFactory<>("amka"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        colHostClinic.setCellValueFactory(new PropertyValueFactory<>("host_clinic"));
        colChamber.setCellValueFactory(new PropertyValueFactory<>("patient_chamber"));
//        tableView.getColumns().addAll(colAmka, colFirstName, colLastName, colHostClinic, colChamber);

        tableView.setItems(iCRUDImpl.getInitialDoctorScreenListItems(user.getHospital_afm(), doctor.getClinic()));

//        iCRUDImpl.getDoctor(user.getUsername()); // Populate Doctor.java in model package.
//        System.out.println(doctor.getClinic());
//        System.out.println(iCRUDImpl.getAllPatientFilesOfClinic(doctor.getClinic()));
//        ObservableList<String> observableListPatientAmka = FXCollections.observableArrayList(iCRUDImpl.getAllPatientFilesOfClinic(doctor.getClinic()).get(0));
//        ObservableList<String> observableListFileId = FXCollections.observableArrayList(iCRUDImpl.getAllPatientFilesOfClinic(doctor.getClinic()).get(1));
//        System.out.println(observableListPatientAmka);
//        patientAmka.setCellValueFactory(data -> data.toString());
//        tableView.setItems(observableListPatientAmka);
//        tableView.setItems(observableListFileId);
    }
}


