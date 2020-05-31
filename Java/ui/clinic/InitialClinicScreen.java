package ui.clinic;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.ClinicAgent;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitialClinicScreen implements Initializable {

    public Button logoutButton;
    public Button pendingAdmissionTicketsButton;
    public Button postButton;
    public Label numberOfPendingTicketLabel;
    public Label postNumLabel;
    public Button clinicInfoButton;
    public Button clinicChangeButton;
    public Label iasoLabel;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    ClinicAgent clinicAgent = new ClinicAgent();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numberOfPendingTicketLabel.setText(iCRUDImpl.getPendingAdmissionTickets(clinicAgent.getClinic(), user.getHospital_afm()));
        postNumLabel.setText(iCRUDImpl.getClinicPosts(clinicAgent.getClinic(), user.getHospital_afm()));
    }

    public void onPendingAdmissionTicketsClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show pending admission tickets");
        openScene("pending_admission_ticket_screen.fxml");
        closeButtonAction();
    }

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Clinic agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onClinicInfoClick(ActionEvent actionEvent) {
        System.out.println("Show clinic info");
    }

    public void onClinicChangeClick(ActionEvent actionEvent) {
        System.out.println("Change clinic");
    }

    public void onPostClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Show posts list screen");
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
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
}
