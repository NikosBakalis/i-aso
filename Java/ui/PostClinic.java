package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PostClinic {
    public Button returnButton;
    public ScrollPane postList;
    public Button createPostButton;

    private void openScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //private void closeButtonAction(){
    //    Stage stage = (Stage) logoutButton.getScene().getWindow();
    //    stage.close();
   // }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        openScene("initial_clinic_screen.fxml");
    //    closeButtonAction();
    }

    public void onCreatePostClick(ActionEvent actionEvent) throws IOException {
        openScene("initial_clinic_screen.fxml");
    }
}
