package ui;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

public class Login {

    public Button loginButtonId;
    public TextField usernameTextId;
    public PasswordField passwordTextId;

    Alert information = new Alert(Alert.AlertType.INFORMATION);
    Alert warning = new Alert(Alert.AlertType.WARNING);
    Alert error = new Alert(Alert.AlertType.ERROR);

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();

    public void clickLoginButton(ActionEvent actionEvent) {
        if(!usernameTextId.getText().trim().isEmpty() && !passwordTextId.getText().trim().isEmpty()){
            if(iCRUDImpl.getUser(usernameTextId.getText()) != null){
                if(user.getPassword().equals(passwordTextId.getText())){
                    System.out.println("Logged in");
                    String option = user.getKind();
                    switch (option){
                        case "Doctor":
                            System.out.println("Doctor");
                            break;
                        case "Lab_Agent":
                            System.out.println("Lab Agent");
                            break;
                        case "Clinic_Agent":
                            System.out.println("Clinic Agent");
                            break;
                        case "Transfer_Office_Agent":
                            System.out.println("Transfer Office Agent");
                            break;
                        case "Admin":
                            System.out.println("Admin");
                            break;
                        default:
                            System.out.println("No match");
                    }
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
                warning.setContentText("No-one with that username is recorded on our database!");
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
}
