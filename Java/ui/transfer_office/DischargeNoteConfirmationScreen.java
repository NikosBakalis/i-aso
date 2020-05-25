package ui.transfer_office;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DischargeNoteConfirmationScreen {
    public Button logoutButton;
    public Button returnButton;
    public AnchorPane dischargeNoteList;

// note that onDischargeNoteClick listener is missing

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Transfer office agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial transfer office screen");
        openScene("initial_transfer_office_screen.fxml");
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
