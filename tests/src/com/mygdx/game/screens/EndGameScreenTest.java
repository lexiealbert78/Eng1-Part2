package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.GdxTestRunner;
import com.mygdx.game.HesHustle;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(GdxTestRunner.class)
public class EndGameScreenTest {

    private static EndGameScreen endGameScreen;
    private static HesHustle game;

    @BeforeClass
    public static void setup() {
        // Sample data for recreational activities counters for two days
        int[][] recCounter = {
                {1, 1, 1},  // Day 1: Ducks = 2, Bench = 3, Football = 1
                {1, 1, 1},   // Day 2: Ducks = 1, Bench = 4, Football = 2
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
                // Add more days as needed
        };

        // Sample values for other inputs
        int[] studyCounter = {3, 5, 0, 0, 0, 0, 0}; // Sample study counts for each day
        int[][] eatCounter = {
                {2, 3},     // Day 1: Breakfast = 2, Lunch = 3
                {1, 4}      // Day 2: Breakfast = 1, Lunch = 4
                // Add more days as needed
        };
        int[] streakAims = {5, 6, 7}; // Sample streak aims passed at the end of the game

        // Initialize the game and main game screen
        game = Mockito.mock(HesHustle.class);

        // Initialize the day screen with sample data
        // Replace null with the appropriate parameters for your constructor
        endGameScreen = new EndGameScreen(game, studyCounter, recCounter, eatCounter, streakAims);
    }


    @Test
    public void show() {
    }

    @Test
    public void render() {
    }

    @Test
    public void calculateScore() {
    }

    @Test
    public void resize() {
    }

    @Test
    public void pause() {
    }

    @Test
    public void resume() {
    }

    @Test
    public void hide() {
    }

    @Test
    public void dispose() {
    }
}