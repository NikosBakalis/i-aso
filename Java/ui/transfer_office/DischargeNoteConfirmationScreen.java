package ui.transfer_office;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;
import ui.clinic.PostDescriptionScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class DischargeNoteConfirmationScreen implements Initializable {
    public Button logoutButton;
    public Button returnButton;
    public AnchorPane dischargeNoteList;

    public TableView<DischargeNoteConfirmationScreenTableItem> tableDischargeNotes;
    public TableColumn<DischargeNoteConfirmationScreenTableItem, String> colAmka;
    public TableColumn<DischargeNoteConfirmationScreenTableItem, String> colFirstName;
    public TableColumn<DischargeNoteConfirmationScreenTableItem, String> colLastName;
    public TableColumn<DischargeNoteConfirmationScreenTableItem, Timestamp> colCreatedAt;
    public TableColumn<DischargeNoteConfirmationScreenTableItem, String> admissionClinic;

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    User user = new User();
    TransferOfficeAgent transferOfficeAgent = new TransferOfficeAgent();
    DischargeNote dischargeNote = new DischargeNote();

    public void onLogoutClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Transfer office agent logout");
        openScene("../login.fxml");
        closeButtonAction();
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial transfer office screen");
        openScene("initial_transfer_office_screen.fxml");
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
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<>("admissionDate"));
        admissionClinic.setCellValueFactory(new PropertyValueFactory<>("clinic"));
        tableDischargeNotes.setItems(iCRUDImpl.getDischargeNoteConfirmationScreenTableItems(user.getHospital_afm()));

        tableDischargeNotes.setRowFactory(tv -> {
            TableRow<DischargeNoteConfirmationScreenTableItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty()) ) {
                    DischargeNoteConfirmationScreenTableItem rowData = row.getItem();
                    System.out.println("Inspect selected discharge note");
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("discharge_note_and_billing_screen.fxml"));
                        Parent parent = loader.load();

                        Scene scene = new Scene(parent);
                        DischargeNoteAndBillingScreen dischargeNoteAndBillingScreen = loader.getController();
                        dischargeNoteAndBillingScreen.noteBilling(rowData.getFileId(), rowData.getAmka());

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
