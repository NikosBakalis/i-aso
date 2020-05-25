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
    public Label acknowledgeNewPatientLabel;
    public Label DischargeNoteConfirmationLAbel;
    public Button patientList;
    public ImageView logoView;
    public Button dischargeNoteConfirmationButton;
    public Button confirmTransfersButton;

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Transfer office agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onAcknowledgeNewPatientClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show new patients with pending tickets");
        openScene("admission_ticket_confirmation_screen.fxml");
        closeButtonAction();
    }

    public void onDischargeNoteConfirmationClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show pending discharge notes");
        openScene("discharge_note_confirmation_screen.fxml");
        closeButtonAction();
    }

    public void onPatientListClick(ActionEvent actionEvent) {
        System.out.println("Show patients list");
    }

    public void onConfirmTransfersClick(ActionEvent actionEvent) {
        System.out.println("Show transfers to confirm");
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
