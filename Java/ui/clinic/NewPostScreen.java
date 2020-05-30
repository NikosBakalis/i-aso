package ui.clinic;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClinicAgent;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class NewPostScreen implements Initializable {
    public Label clinicNameLabel;
    public Label dateLabel;
    public Button returnButton;
    public TextArea postText;
    public Button uploadButton;
    public TextField titleField;
    public TextField authorField;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    ClinicAgent clinicAgent = new ClinicAgent();

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to posts list screen");
        openScene("post_list_screen.fxml");
        closeButtonAction();
    }

    public void onUploadClick(ActionEvent actionEvent) throws IOException {
        String author = authorField.getText();
        String title = titleField.getText();
        String post = postText.getText().replaceAll("\n", System.getProperty("line.separator"));
        String clinicName = clinicAgent.getClinic();
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);
        int uploadComplete = iCRUDImpl.savePost(clinicName, author, date, title, post);
        if (uploadComplete > 0) {
            System.out.println("Post uploaded");
        }
        else {
            System.out.println("Error: Upload failed");
        }
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date dt = new java.util.Date();
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        dateLabel.setText(currentTime);
        clinicNameLabel.setText(clinicAgent.getClinic());
        postText.setWrapText(true);
    }
}
