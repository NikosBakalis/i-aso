package ui.clinic;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class PendingAdmissionTicketScreen implements Initializable {
    public Button logoutButton;
    public Button returnButton;
    public Label clinicNameLabel;
    public TableView<PendingAdmissionTicketsScreenListItem> tableView;
    public TableColumn<PendingAdmissionTicketsScreenListItem, String> colAmka;
    public TableColumn<PendingAdmissionTicketsScreenListItem, String> colFirstName;
    public TableColumn<PendingAdmissionTicketsScreenListItem, String> colLastName;
    public TableColumn<PendingAdmissionTicketsScreenListItem, Timestamp> colCreatedAt;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    ClinicAgent clinicAgent = new ClinicAgent();

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Clinic agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial clinic screen");
        openScene("initial_clinic_screen.fxml");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colAmka.setCellValueFactory(new PropertyValueFactory<>("amka"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        tableView.setItems(iCRUDImpl.getPendingAdmissionTicketsScreenListItems(user.getHospital_afm(), clinicAgent.getClinic()));

        tableView.setRowFactory(tv -> {
            TableRow<PendingAdmissionTicketsScreenListItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    PendingAdmissionTicketsScreenListItem rowData = row.getItem();
                    System.out.println("Inspect selected admission ticket");
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("admission_ticket_details_screen.fxml"));
                        Parent parent = loader.load();

                        Scene scene = new Scene(parent);
                        AdmissionTicketDetailsScreen admissionTicketDetailsScreen = loader.getController();
                        admissionTicketDetailsScreen.setAdmissionTicketDetails(rowData.getAmka(), rowData.getTicketId());

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
