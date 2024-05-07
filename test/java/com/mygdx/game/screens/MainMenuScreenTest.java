package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.mygdx.game.HesHustle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class MainMenuScreenTest {

    private static MainMenuScreen mainMenuScreen;
    private static HesHustle game;
    private static MainGameScreen mainGameScreen;

    @BeforeAll
    static void setup() {
        game = Mockito.mock(HesHustle.class);
        mainGameScreen = Mockito.mock(MainGameScreen.class);
        mainMenuScreen = new MainMenuScreen(game, mainGameScreen);
    }

    @Test
    public void testPlayButtonClicked() {
        // Simulate a mouse click within the play button bounds
        simulateMouseClick((int) (mainMenuScreen.getPlayButtonBounds().x + 10), (int) (mainMenuScreen.getPlayButtonBounds().y + 10));

        // Verify that setScreen is called with expected arguments
        verify(game).setScreen(any());
    }

    @Test
    public void testLeaderboardButtonClicked() {
        // Simulate a mouse click within the play button bounds
        simulateMouseClick((int) (mainMenuScreen.getLeaderButtonBounds().x + 10), (int) (mainMenuScreen.getLeaderButtonBounds().y + 10));

        // Verify that setScreen is called with expected arguments
        verify(game).setScreen(any());
    }

    @Test
    public void testEnlargeScreenButtonClicked() {
        // Simulate a mouse click within the play button bounds
        int width = mainMenuScreen.fullButtonTexture.getWidth();
        simulateMouseClick((int) (mainMenuScreen.getFullButtonBounds().x + 10), (int) (mainMenuScreen.getFullButtonBounds().y + 10));

        // Verify that setScreen is called with expected arguments
        assertNotEquals(width, mainMenuScreen.fullButtonTexture.getWidth());
    }

    @Test
    public void testMuteScreenButtonClicked() {
        // Simulate a mouse click within the play button bounds
        simulateMouseClick((int) (mainMenuScreen.getMuteButtonBounds().x + 10), (int) (mainMenuScreen.getMuteButtonBounds().y + 10));

        // Verify that setScreen is called with expected arguments
        assertEquals(0, game.backgroundMusic.getVolume());
    }

    @Test
    public void testQuitButtonClicked() {
        // Simulate a mouse click within the quit button bounds
        simulateMouseClick((int) (mainMenuScreen.getQuitButtonBounds().x + 10), (int) (mainMenuScreen.getQuitButtonBounds().y + 10));

        // Verify that Gdx.app.exit() is called
        verify(Gdx.app).exit();
    }

    // Helper method to simulate a mouse click
    private void simulateMouseClick(int x, int y) {
        // Mock input
        Input input = Mockito.mock(Input.class);
        when(Gdx.input).thenReturn(input);

        // Simulate mouse coordinates
        when(input.justTouched()).thenReturn(true);
        when(input.getX()).thenReturn(x);
        when(input.getY()).thenReturn(y);
    }
}
