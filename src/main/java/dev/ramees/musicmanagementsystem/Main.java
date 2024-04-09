package dev.ramees.musicmanagementsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Music Management System");

        // Create a VBox layout
        VBox vbox = new VBox();

        // Add UI components to the VBox
        Button button = new Button("Click me!");
        vbox.getChildren().add(button);

        // Create a scene with the VBox as the root node
        Scene scene = new Scene(vbox, 800, 600);

        // Set the scene to the stage and display it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
