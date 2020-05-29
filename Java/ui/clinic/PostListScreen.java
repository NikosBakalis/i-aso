package ui.clinic;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.ClinicAgent;
import model.Doctor;
import model.PostListScreenTableItem;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class PostListScreen implements Initializable  {
    public Button returnButton;
    public Button createPostButton;
    public Label postLabel;
    public TableView<PostListScreenTableItem> postList;
    public TableColumn<PostListScreenTableItem, Timestamp> colDateTime;
    public TableColumn<PostListScreenTableItem, String> colAuthor;
    public TableColumn<PostListScreenTableItem, String> colTitle;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    ClinicAgent clinicAgent = new ClinicAgent();

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial clinic screen");
        openScene("initial_clinic_screen.fxml");
        closeButtonAction();
    }

    public void onCreatePostClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Create new post");
        openScene("new_post_screen.fxml");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colDateTime.setCellValueFactory(new PropertyValueFactory<>("postDatetime"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("postAuthor"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("postTitle"));
        postList.setItems(iCRUDImpl.getPostListScreenTableItems(clinicAgent.getClinic()));

        postList.setRowFactory(tv -> {
            TableRow<PostListScreenTableItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    PostListScreenTableItem rowData = row.getItem();
                    System.out.println("Inspect selected post");
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("post_description_screen.fxml"));
                        Parent parent = loader.load();

                        Scene scene = new Scene(parent);
                        PostDescriptionScreen postDescriptionScreen = loader.getController();
                        postDescriptionScreen.postDescription(rowData.getPostId());

                        Stage primaryStage = new Stage();

                        primaryStage.setTitle("I-aso");
                        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
                        primaryStage.setScene(scene);
                        primaryStage.show();

                        closeButtonAction();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });
    }
}
