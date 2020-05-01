package ui;

import database.ICRUDImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;

public class Login extends Application {

    public Button loginButtonId;
    public TextField usernameTextId;
    public PasswordField passwordTextId;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void clickLoginButton(ActionEvent actionEvent) {
        iCRUDImpl.openConnection();
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
            }
        }
    }
}
