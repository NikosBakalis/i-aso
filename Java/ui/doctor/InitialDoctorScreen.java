package ui.doctor;

import database.ICRUDImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Doctor;
import model.PatientFile;
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
    public TableView<String> tableView;
    public TableColumn patientAmka;
    public TableColumn fileId;
    public TableColumn hospital;
    public TableColumn clinic;
    public TableColumn diagnosis;
    public TableColumn treatment;
    public TableColumn lab_tests;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    Doctor doctor = new Doctor();
    PatientFile patientFile = new PatientFile();

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
        iCRUDImpl.getDoctor(user.getUsername()); // Populate Doctor.java in model package.
        System.out.println(doctor.getClinic());
        System.out.println(iCRUDImpl.getAllPatientFilesOfClinic(doctor.getClinic()));
        ObservableList<String> observableListPatientAmka = FXCollections.observableArrayList(iCRUDImpl.getAllPatientFilesOfClinic(doctor.getClinic()).get(0));
//        ObservableList<String> observableListFileId = FXCollections.observableArrayList(iCRUDImpl.getAllPatientFilesOfClinic(doctor.getClinic()).get(1));
        System.out.println(observableListPatientAmka);
//        patientAmka.setCellValueFactory(data -> data.toString());
        tableView.setItems(observableListPatientAmka);
//        tableView.setItems(observableListFileId);
    }
}


