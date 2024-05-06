package com.mygdx.game.screens;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreWriter {
    public static void writeScore(String playerName, int score) {
        try {
            // Maximum number of scores to keep
            int maxScores = 10;

            // Open a file reader to read existing scores
            BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
            // Create a string to hold the updated scores
            StringBuilder updatedScores = new StringBuilder();

            String line;
            boolean scoreWritten = false;
            int scoresCount = 0;

            // Read existing scores line by line, up to the maximum allowed scores
            while ((line = reader.readLine()) != null && scoresCount < maxScores) {
                String[] parts = line.split(" ");
                // Extract player name and score from the line
                String existingPlayerName = parts[0];
                int existingScore = Integer.parseInt(parts[1]);

                // Check if the new score is higher than the existing score
                if (score > existingScore && !scoreWritten) {
                    // Write the new score before the existing one
                    updatedScores.append(playerName).append(" ").append(score).append("\n");
                    scoreWritten = true;
                    scoresCount++; // Increment the score count
                }
                // Write the existing score to the updated scores string
                updatedScores.append(existingPlayerName).append(" ").append(existingScore).append("\n");
                scoresCount++; // Increment the score count
            }

            // If the new score wasn't written yet (e.g., it's lower than all existing scores), write it at the end
            if (!scoreWritten && scoresCount < maxScores) {
                updatedScores.append(playerName).append(" ").append(score).append("\n");
                scoresCount++; // Increment the score count
            }

            // Close the reader
            reader.close();

            // Open a file writer in overwrite mode to write the updated scores back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt"));
            // Write the updated scores to the file
            writer.write(updatedScores.toString());
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

