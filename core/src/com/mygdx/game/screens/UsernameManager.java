package com.mygdx.game.screens;

public class UsernameManager {
    private static UsernameManager instance;
    private String username;

    private UsernameManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized UsernameManager getInstance() {
        if (instance == null) {
            instance = new UsernameManager();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

