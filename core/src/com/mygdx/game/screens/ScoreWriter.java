package com.mygdx.game.screens;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreWriter {
    public static void writeScore(String playerName, int score) {
        try {
            // Open a file writer in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true));
            // Write the player's name and score to the file on the same line, separated by a space
            writer.write(playerName + " " + score);
            writer.newLine(); // Add a new line for each entry
            // Close the writer
            writer.close();
            System.out.println("Score saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> readScores() {
        List<String> scores = new ArrayList<>();

        try {
            // Open a file reader
            BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                scores.add(line);
            }
            // Close the reader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scores;
    }
}

