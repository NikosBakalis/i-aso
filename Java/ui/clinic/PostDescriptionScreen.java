package ui.clinic;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import model.ClinicAgent;
import model.ClinicAgentPost;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PostDescriptionScreen  {
    public Button returnButton;
    public ScrollPane selectedPost;
    public Label postLabel;
    public ScrollPane postSelect;

    public ClinicAgentPost post;

    public Label postTitle;
    public Label postAuthor;
    public Label postDate;
    public Label postText;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();

    public void postDescription(String postId) {
        post = iCRUDImpl.getClinicAgentPost(postId);
        postDate.setText(post.getCreatedAt().toString());
        postAuthor.setText(post.getAuthor());
        postTitle.setText(post.getTitle());
        postText.setText(post.getText());
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to posts list screen");
        openScene("post_list_screen.fxml");
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
