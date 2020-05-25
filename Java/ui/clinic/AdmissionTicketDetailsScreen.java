package ui.clinic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdmissionTicketDetailsScreen {
    public Label clinicNameLabel;
    public Button returnButton;
    public Button saveButton;
    public ComboBox chamberMenu;
    public ComboBox bedMenu;

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show pending admission tickets");
        openScene("pending_admission_ticket_screen.fxml");
        closeButtonAction();
    }

    public void onSaveClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to posts list screen");
        openScene("initial_clinic_screen.fxml");
        closeButtonAction();
    }

    public void onChamberSelect(ActionEvent actionEvent) {
        System.out.println("Chamber selected");
    }

    public void onBedSelect(ActionEvent actionEvent) {
        System.out.println("Bed selected");
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
