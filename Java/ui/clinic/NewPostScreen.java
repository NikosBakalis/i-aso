package ui.clinic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPostScreen {
    public Label clinicNameLabel;
    public Label dateLabel;
    public Label authorLabel;
    public Button returnButton;
    public TextArea postText;
    public Button uploadButton;

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        openScene("post_list_screen.fxml");
       // closeButtonAction();
    }
    private void openScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void onUploadClick(ActionEvent actionEvent) throws IOException {
        openScene("post_list_screen.fxml");
        // closeButtonAction();
    }

    //private void closeButtonAction(){
    //    Stage stage = (Stage) logoutButton.getScene().getWindow();
    //    stage.close();
   // }


}
