import database.ICRUDImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Lab;

import java.io.IOException;

public class TestTheMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ui/login.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("ui/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        ICRUDImpl iCRUDImpl = new ICRUDImpl();
        iCRUDImpl.openConnection();
        iCRUDImpl.getLab("123456", "lab");
        System.out.println(Lab.getName());
    }
}
