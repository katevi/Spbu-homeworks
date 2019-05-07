package Vinnik.g144;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /** Starts the calculator application. */
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
            primaryStage.setTitle("Calculator:)");
            primaryStage.setMinHeight(100);
            primaryStage.setMinWidth(500);
            primaryStage.setScene(new Scene(root, 600, 150));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}