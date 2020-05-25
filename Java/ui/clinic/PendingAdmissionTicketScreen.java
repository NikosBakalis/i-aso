package ui.clinic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class PendingAdmissionTicketScreen {
    public Button logoutButton;
    public Button returnButton;
    public Label clinicNameLabel;
    public TableView pendingAdmissionTicketList;

    //  onPendingAdmissionTicketClick is missing

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Clinic agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial clinic screen");
        openScene("initial_clinic_screen.fxml");
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
}
