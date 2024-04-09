package dev.ramees.musicmanagementsystem.controllers;

import dev.ramees.musicmanagementsystem.services.SocketService;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainController {
    private final SocketService socketService;

    public MainController() {
        this.socketService = new SocketService();
    }

    public VBox createMainUI() {
        VBox root = new VBox(10);

        // Create UI controls
        Label titleLabel = new Label("Songs:");
        TextArea songTextArea = new TextArea();
        songTextArea.setEditable(false);
        songTextArea.setPrefRowCount(10);
        songTextArea.setPrefColumnCount(40);

        // Add UI controls to the root VBox
        root.getChildren().addAll(titleLabel, songTextArea);

        // Fetch and display songs
        List<String> songs = socketService.browseSongs();
        for (String song : songs) {
            songTextArea.appendText(song + "\n");
        }

        return root;
    }
}
