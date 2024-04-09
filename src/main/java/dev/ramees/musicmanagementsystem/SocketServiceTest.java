package dev.ramees.musicmanagementsystem;

import dev.ramees.musicmanagementsystem.models.Song;
import dev.ramees.musicmanagementsystem.services.MockServer;
import dev.ramees.musicmanagementsystem.services.SocketService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

public class SocketServiceTest {
    private static final int PORT = 12345;

    public static void main(String[] args) {
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
        List<String> songs = socketService.browseSongs();
        for (String song : songs) {
            System.out.println(song);
        }
    }
}
