package dev.ramees.musicmanagementsystem;

import dev.ramees.musicmanagementsystem.controllers.MainController;
import dev.ramees.musicmanagementsystem.services.MockServer;
import dev.ramees.musicmanagementsystem.services.SocketService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the MainController
        MainController mainController = new MainController();

        // Start the mock server in a separate thread
        new Thread(() -> {
            MockServer mockServer = new MockServer();
            mockServer.start();
        }).start();

        // Wait for a short duration to ensure the mock server starts
        try {
            Thread.sleep(1000); // Wait for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now, test the SocketService
        SocketService socketService = new SocketService();

        // Create the main UI
        Scene scene = new Scene(mainController.createMainUI(), 400, 300);

        // Set the scene for the primary stage
        primaryStage.setTitle("Music Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
