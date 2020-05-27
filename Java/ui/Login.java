package ui;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Doctor;
import model.User;

import java.io.IOException;

public class Login {

    public Button loginButtonId;
    public TextField usernameTextId;
    public PasswordField passwordTextId;

    Alert information = new Alert(Alert.AlertType.INFORMATION);
    Alert warning = new Alert(Alert.AlertType.WARNING);
    Alert error = new Alert(Alert.AlertType.ERROR);

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();

    public void clickLoginButton(ActionEvent actionEvent) throws IOException {
        if(!usernameTextId.getText().trim().isEmpty() && !passwordTextId.getText().trim().isEmpty()){
            if(iCRUDImpl.getUser(usernameTextId.getText()) != null){
                if(user.getPassword().equals(passwordTextId.getText())){
                    System.out.println("Logged in");
                    String option = user.getSpecification();
                    switch (option){
                        case "Doctor":
                            System.out.println("Doctor");
                            iCRUDImpl.getDoctor(user.getUsername());
                            openScene("doctor/initial_doctor_screen.fxml");
                            break;
                        case "Lab_Agent":
                            System.out.println("Lab Agent");
                            openScene(".fxml");
                            break;
                        case "Clinic_Agent":
                            System.out.println("Clinic Agent");
                            openScene("clinic/initial_clinic_screen.fxml");
                            break;
                        case "Transfer_Office_Agent":
                            System.out.println("Transfer Office Agent");
                            openScene("transfer_office/initial_transfer_office_screen.fxml");
                            break;
                        case "Admin":
                            System.out.println("Admin");
                            openScene("admin_choose_hospital.fxml");
                            break;
                        default:
                            System.out.println("No match");
                    }
                    closeButtonAction();
                } else {
                    System.err.println("Wrong password!");
                    information.setTitle("Information");
                    information.setHeaderText("Wrong password");
                    information.setContentText("Please try again!");
                    information.showAndWait();
                }
            } else {
                System.err.println("There is no user with that username!");
                warning.setTitle("Warning");
                warning.setHeaderText("No user found");
                warning.setContentText("No-one with that username is recorded in our database!");
                warning.showAndWait();
            }
        } else {
            System.err.println("Null values!");
            error.setTitle("Error");
            error.setHeaderText("Empty fields");
            error.setContentText("Please fill all fields!");
            error.showAndWait();
        }
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

    private void closeButtonAction(){
        Stage stage = (Stage) loginButtonId.getScene().getWindow();
        stage.close();
    }
}
