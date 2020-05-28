package ui.doctor;

import database.ICRUDImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Doctor;
import model.PossibleMatchesScreenListItem;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PossibleMatchesScreen implements Initializable {
    public Button returnButton;
    public Button confirmationButton;
    public TableView<PossibleMatchesScreenListItem> tableView;
    public TableColumn<PossibleMatchesScreenListItem, String> colFirstName;
    public TableColumn<PossibleMatchesScreenListItem, String> colLastName;
    public TableColumn<PossibleMatchesScreenListItem, String> colAmka;
    public TableColumn<PossibleMatchesScreenListItem, String> colAfm;
    public TableColumn<PossibleMatchesScreenListItem, String> colBirthDate;
    public TableColumn<PossibleMatchesScreenListItem, String> colSex;
    public TableColumn<PossibleMatchesScreenListItem, String> colFatherFirstName;
    public TableColumn<PossibleMatchesScreenListItem, String> colMotherFirstName;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    Doctor doctor = new Doctor();


    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to new patient info screen");
        openScene("new_patient_info_screen.fxml");
        closeButtonAction();
    }

    public void onConfirmationClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Patient confirmation");
        openScene("patient_file_screen.fxml");
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

    public void populateTable(ObservableList<PossibleMatchesScreenListItem> possibleMatchesScreenListItems) {
        tableView.setItems(possibleMatchesScreenListItems);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colAmka.setCellValueFactory(new PropertyValueFactory<>("amka"));
        colAfm.setCellValueFactory(new PropertyValueFactory<>("afm"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        colSex.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colFatherFirstName.setCellValueFactory(new PropertyValueFactory<>("fatherFirstName"));
        colMotherFirstName.setCellValueFactory(new PropertyValueFactory<>("motherFirstName"));
    }
}
