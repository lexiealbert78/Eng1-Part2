package com.mygdx.game.screens;

import java.io.Serializable;

public class PlayerScore implements Serializable {
    private String playerName;
    private int score;

    public PlayerScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    // Getters and setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

