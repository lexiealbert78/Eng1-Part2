package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.mygdx.game.GdxTestRunner;

import com.mygdx.game.HesHustle;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(GdxTestRunner.class)
public class DayScreenTest {

    private static HesHustle game;
    private static DayScreen dayScreen;
    private static Screen mainGameScreen;

    @BeforeClass
    public static void setup() {
        // Sample data for recreational activities counters for two days
        int[][] recCounter = {
                {1, 1, 1},  // Day 1: Ducks = 2, Bench = 3, Football = 1
                {1, 1, 1},   // Day 2: Ducks = 1, Bench = 4, Football = 2
                {1, 1, 1},
                {0, 1, 1},
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
                // Add more days as needed
        };

        // Sample values for other inputs
        int day = 1;
        int[] studyCounter = {3, 5, 0, 0, 0, 0, 0}; // Sample study counts for each day
        int[][] eatCounter = {
                {2, 3},     // Day 1: Breakfast = 2, Lunch = 3
                {1, 4}      // Day 2: Breakfast = 1, Lunch = 4
                // Add more days as needed
        };
        int[] streakAims = {5, 6, 7}; // Sample streak aims passed at the end of the game

        // Initialize the game and main game screen
        game = Mockito.mock(HesHustle.class);
        mainGameScreen = Mockito.mock(MainGameScreen.class);

        // Initialize the day screen with sample data
        // Replace null with the appropriate parameters for your constructor
        dayScreen = new DayScreen(game, mainGameScreen, day, studyCounter, recCounter, eatCounter, streakAims);
    }


    @Test
    public void testTotal() {
        // Test the Total method for "recduck"
        int totalDucks = dayScreen.Total("recduck");
        assertEquals(3, totalDucks); // Expected total for recduck is 3 (2 ducks on day 1 + 1 duck on day 2)

        // Test the Total method for "recbench"
        int totalBench = dayScreen.Total("recbench");
        assertEquals(5, totalBench); // Expected total for recbench is 7 (3 bench on day 1 + 4 bench on day 2)

        // Test the Total method for "recfootball"
        assertEquals(4,  dayScreen.Total("recfootball")); // Expected total for recfootball is 3 (1 football on day 1 + 2 football on day 2)
    }


}