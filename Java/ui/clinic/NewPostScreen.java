package ui.clinic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPostScreen {
    public Label clinicNameLabel;
    public Label dateLabel;
    public Button returnButton;
    public TextArea postText;
    public Button uploadButton;
    public TextField titleField;
    public TextField authorField;

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to posts list screen");
        openScene("post_list_screen.fxml");
        closeButtonAction();
    }

    public void onUploadClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Post uploaded");
        openScene("post_list_screen.fxml");
        closeButtonAction();
    }

    private void closeButtonAction(){
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
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
}
