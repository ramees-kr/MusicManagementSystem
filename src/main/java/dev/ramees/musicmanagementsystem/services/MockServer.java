package dev.ramees.musicmanagementsystem.services;
import dev.ramees.musicmanagementsystem.models.Song;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MockServer {
    private static final int PORT = 12345; // Port number for the mock server

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Mock Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Handle client request
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                List<Song> songs = generateSampleSongs();
                for (Song song : songs) {
                    out.println(song);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Song> generateSampleSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Anthem", "DIPLO & SHARAM ft PONY"));
        songs.add(new Song("Fen Violet", "UNDERWORLD ft KETTAMA"));
        songs.add(new Song("Breaking Down", "GUSGUS ft EARTH & HÖGNI"));
        songs.add(new Song("Mustang", "KINGS OF LEON"));
        songs.add(new Song("Turn the Lights Back On", "BILLY JOEL"));
        songs.add(new Song("Oh", "THE LIBERTINES"));
        songs.add(new Song("Tuta Gold", "MAHMOOD"));
        songs.add(new Song("Sinceramente", "ANNALISA"));
        songs.add(new Song("Favourite Song", "MAXIMO PARK"));
        songs.add(new Song("Click Boom!", "ROSE VILLAIN"));

        return songs;
    }
}