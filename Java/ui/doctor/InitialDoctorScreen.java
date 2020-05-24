package ui.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InitialDoctorScreen {
    public Label titleLabelId;
    public Button logoutButton;
    public Button newPatientButton;
    public Button profileButton;

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
}


