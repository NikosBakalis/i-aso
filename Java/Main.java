import database.ICRUDImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of the program. Extends application so as to produce fxml.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Here the main screen (login.fxml) appears and the program starts.
     * @param primaryStage auto generated attribute of start method that initializes the stage.
     * @throws IOException auto generated exception that throws all interrupted I/O operations.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ui/login.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("ui/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

//        Opens connection from ICRUDImpl class.
        ICRUDImpl iCRUDImpl = new ICRUDImpl();
        iCRUDImpl.openConnection();
    }
}
