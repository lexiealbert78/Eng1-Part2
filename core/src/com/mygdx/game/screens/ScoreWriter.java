package com.mygdx.game.screens;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreWriter {
    public static void writeScore(String playerName, int score) {
        // Create a data structure to store player's name and score
        PlayerScore playerScore = new PlayerScore(playerName, score);

        try {
            // Open a file output stream in append mode
            FileOutputStream fileOut = new FileOutputStream("scores.dat", true);
            // Create an ObjectOutputStream
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            // Write the player's score object to the file
            objectOut.writeObject(playerScore);
            // Close the output streams
            objectOut.close();
            fileOut.close();
            System.out.println("Score saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PlayerScore> readScores() {
        List<PlayerScore> scores = new ArrayList<>();

        try {
            // Open a file input stream
            FileInputStream fileIn = new FileInputStream("scores.dat");
            // Create an ObjectInputStream
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Read objects from the file until EOFException is caught
            while (true) {
                try {
                    // Read a PlayerScore object from the file
                    PlayerScore playerScore = (PlayerScore) objectIn.readObject();
                    // Add the PlayerScore object to the list
                    scores.add(playerScore);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // Reached end of file, so no need to handle anything
        }

        return scores;
    }
}
