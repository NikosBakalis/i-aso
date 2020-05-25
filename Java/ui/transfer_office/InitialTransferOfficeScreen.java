package ui.transfer_office;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class InitialTransferOfficeScreen {
    public Button logoutButton;
    public Button acknowledgeNewPatientButton;
    public Label iasoLabel;
    public Button DischargeNoteConfirmationButton;
    public Label acknowledgeNewPatientLabel;
    public Label DischargeNoteConfirmationLAbel;
    public Button patientList;
    public ImageView logoView;

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onAcknowledgeNewPatientClick(ActionEvent actionEvent) throws IOException {
        openScene("admission_ticket_confirmation_screen.fxml");
        closeButtonAction();
    }

    public void onDischargeNoteConfirmationClick(ActionEvent actionEvent) throws IOException {
        openScene("discharge_note_confirmation_screen.fxml");
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
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }

    public void onPatientListClick(ActionEvent actionEvent) {
    }
}
