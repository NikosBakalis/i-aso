package ui;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

public class Login {

    public Button loginButtonId;
    public TextField usernameTextId;
    public PasswordField passwordTextId;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();

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
