package dev.ramees.musicmanagementsystem.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketService {
    private static final String SERVER_ADDRESS = "localhost"; // Server address
    private static final int SERVER_PORT = 12345; // Port number for the mock server

    public List<String> browseSongs() {
        List<String> songs = new ArrayList<>();

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a request to the mock server to browse songs
            out.println("BROWSE_SONGS");

            // Receive and process the response from the mock server
            String response;
            while ((response = in.readLine()) != null) {
                // Add each song to the list
                songs.add(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songs;
    }
}
