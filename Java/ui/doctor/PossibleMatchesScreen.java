package ui.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PossibleMatchesScreen {
    public Button returnButton;
    public Button confirmationButton;

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to new patient info screen");
        openScene("new_patient_info_screen.fxml");
        closeButtonAction();
    }

    public void onConfirmationClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Patient confirmation");
        openScene("patient_file_screen.fxml");
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
}
