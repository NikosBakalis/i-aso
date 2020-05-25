package ui.transfer_office;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TemporaryAdmissionTicketScreen {
    public Button returnButton;
    public Button confirmButton;

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to admission tickets list");
        openScene("admission_ticket_confirmation_screen.fxml");
        closeButtonAction();
    }

    public void onConfirmClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Admission ticket confirmed");
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
}
