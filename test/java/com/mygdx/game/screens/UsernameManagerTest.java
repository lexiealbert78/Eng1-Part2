package com.mygdx.game.screens;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsernameManagerTest {

    // instantiates a username "Test" and checks that exists and is "Test"
    @Test
    void Stores_correct_username() {
        UsernameManager.getInstance().setUsername("Test");
        assertEquals("Test", UsernameManager.getInstance().getUsername());
    }
}