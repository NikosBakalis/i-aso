package ui.doctor;

import database.ICRUDImpl;
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
    public TableColumn<InitialDoctorScreenListItem, String> colAmka;
    public TableColumn<InitialDoctorScreenListItem, String> colFirstName;
    public TableColumn<InitialDoctorScreenListItem, String> colLastName;
    public TableColumn<InitialDoctorScreenListItem, String> colHostClinic;
    public TableColumn<InitialDoctorScreenListItem, String> colChamber;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    Doctor doctor = new Doctor();
    InitialDoctorScreenListItem initialDoctorScreenListItem = new InitialDoctorScreenListItem();

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
        colAmka.setCellValueFactory(new PropertyValueFactory<>("amka"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colHostClinic.setCellValueFactory(new PropertyValueFactory<>("hostClinic"));
        colChamber.setCellValueFactory(new PropertyValueFactory<>("patientChamber"));
        tableView.setItems(iCRUDImpl.getInitialDoctorScreenListItems(user.getHospital_afm(), doctor.getClinic()));
    }
}


