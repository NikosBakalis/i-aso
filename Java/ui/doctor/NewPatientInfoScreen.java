package ui.doctor;

import database.ICRUDImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.PossibleMatchesScreenListItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewPatientInfoScreen implements Initializable {
    public Button searchButton;
    public Button returnButton;
    public TextField amkaField;
    public TextField afmField;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField fatherFirstNameField;
    public TextField fatherLastNameField;
    public TextField motherFirstNameField;
    public TextField motherLastNameField;
    public DatePicker birthDateField;
    public ChoiceBox genderChoiceBox;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Alert error = new Alert(Alert.AlertType.ERROR);

    public void onSearchClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Search for matches");
        String amka, afm, firstName, lastName, gender, fatherFirstName, fatherLastName, motherFirstName, motherLastName, birthDate;
        boolean atLeastOneIsNotEmpty = false;

        if ( amkaField.getText() == null || amkaField.getText().trim().isEmpty()) {
            amka = "";
        } else {
            amka = amkaField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( afmField.getText() == null || afmField.getText().trim().isEmpty()) {
            afm = "";
        } else {
            afm = afmField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( firstNameField.getText() == null || firstNameField.getText().trim().isEmpty()) {
            firstName = "";
        } else {
            firstName = firstNameField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( lastNameField.getText() == null || lastNameField.getText().trim().isEmpty()) {
            lastName = "";
        } else {
            lastName = lastNameField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( genderChoiceBox.getSelectionModel().isEmpty()) {
            gender = "";
        } else {
            gender = genderChoiceBox.getValue().toString();
            atLeastOneIsNotEmpty = true;
        }
        if ( fatherFirstNameField.getText() == null || fatherFirstNameField.getText().trim().isEmpty()) {
            fatherFirstName = "";
        } else {
            fatherFirstName = fatherFirstNameField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( fatherLastNameField.getText() == null || fatherLastNameField.getText().trim().isEmpty()) {
            fatherLastName = "";
        } else {
            fatherLastName = fatherLastNameField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( motherFirstNameField.getText() == null || motherFirstNameField.getText().trim().isEmpty()) {
            motherFirstName = "";
        } else {
            motherFirstName = motherFirstNameField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( motherLastNameField.getText() == null || motherLastNameField.getText().trim().isEmpty()) {
            motherLastName = "";
        } else {
            motherLastName = motherLastNameField.getText().trim();
            atLeastOneIsNotEmpty = true;
        }
        if ( birthDateField.getValue() == null) {
            birthDate = "";
        } else {
            birthDate = birthDateField.getValue().toString();
            atLeastOneIsNotEmpty = true;
        }
        System.out.println(amka);
        System.out.println(afm);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(gender);
        System.out.println(fatherFirstName);
        System.out.println(fatherLastName);
        System.out.println(motherFirstName);
        System.out.println(motherLastName);
        System.out.println(birthDate);
        System.out.println(atLeastOneIsNotEmpty);

        if (atLeastOneIsNotEmpty) {
            ObservableList<PossibleMatchesScreenListItem> possibleMatchesScreenListItems =
                    iCRUDImpl.getPossibleMatchesScreenListItems(amka, afm, firstName, lastName, gender,
                    fatherFirstName, fatherLastName, motherFirstName, motherLastName, birthDate);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("possible_matches_screen.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            PossibleMatchesScreen possibleMatchesScreen = loader.getController();
            possibleMatchesScreen.populateTable(possibleMatchesScreenListItems);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("I-aso");
            scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            closeButtonAction();

        } else {
            System.err.println("Null values!");
            error.setTitle("Error");
            error.setHeaderText("Empty fields");
            error.setContentText("Please fill all fields!");
            error.showAndWait();
        }
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial doctor screen");
        openScene("initial_doctor_screen.fxml");
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
        genderChoiceBox.getItems().addAll("ΑΝΔΡΑΣ","ΓΥΝΑΙΚΑ","ΑΛΛΟ");
    }
}
