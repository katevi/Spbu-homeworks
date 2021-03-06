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

    /** If the file exists, displays the graphical interface of the calculator. */
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
            primaryStage.setTitle("Calculator:)");
            primaryStage.setMinWidth(400);
            primaryStage.setMinHeight(500);
            primaryStage.setScene(new Scene(root, 400, 500));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}