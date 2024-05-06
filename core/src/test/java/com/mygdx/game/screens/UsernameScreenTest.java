package com.mygdx.game.screens;

import com.mygdx.game.HesHustle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsernameScreenTest {

    @Test
    public void testGetPlayerName() {
        HesHustle game = new HesHustle();
        UsernameScreen usernameScreen = new UsernameScreen(game);
        UsernameManager.getInstance().setUsername("Test");

        assertEquals("Test", usernameScreen.getPlayerName());
    }
}
