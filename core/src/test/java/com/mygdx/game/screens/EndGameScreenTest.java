package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.HesHustle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class EndGameScreenTest {

    private static EndGameScreen endGameScreen;
    private static HesHustle game;

    @BeforeAll
    static void setup() {
        // Sample data for recreational activities counters for two days
        int[][] recCounter = {
                {2, 3, 1},  // Day 1: Ducks = 2, Bench = 3, Football = 1
                {1, 4, 2}   // Day 2: Ducks = 1, Bench = 4, Football = 2
                // Add more days as needed
        };

        // Sample values for other inputs
        int day = 1; // Current day
        int[] studyCounter = {3, 5}; // Sample study counts for each day
        int[][] eatCounter = {
                {2, 3},     // Day 1: Breakfast = 2, Lunch = 3
                {1, 4}      // Day 2: Breakfast = 1, Lunch = 4
                // Add more days as needed
        };
        int[] streakAims = {5, 6, 7}; // Sample streak aims passed at the end of the game

        // Initialize the game and main game screen
        HesHustle game = Mockito.mock(HesHustle.class);

        // Initialize the day screen with sample data
        // Replace null with the appropriate parameters for your constructor
        endGameScreen = new EndGameScreen(game, studyCounter, recCounter, eatCounter, streakAims);
    }


    @Test
    public void testContinueButtonPressed() {
        // Simulate a button press
        endGameScreen.render(0);

        // Assuming your button press logic is triggered by F key press
        when(Gdx.input.isKeyJustPressed(Input.Keys.F)).thenReturn(true);

        // Call render again to handle button press
        endGameScreen.render(0);
        // Verify that the screen changes to the MainGameScreen
        verify(game).setScreen(any());
    }

    @Test
    void show() {
    }

    @Test
    void render() {
    }

    @Test
    void calculateScore() {
    }

    @Test
    void resize() {
    }

    @Test
    void pause() {
    }

    @Test
    void resume() {
    }

    @Test
    void hide() {
    }

    @Test
    void dispose() {
    }
}