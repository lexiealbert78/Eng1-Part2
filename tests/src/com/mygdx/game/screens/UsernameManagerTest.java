package com.mygdx.game.screens;



import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsernameManagerTest {

    // instantiates a username "Test" and checks that exists and is "Test"
    @Test
    public void Stores_correct_username() {
        UsernameManager.getInstance().setUsername("Test");
        assertEquals("Test", UsernameManager.getInstance().getUsername());
    }
}