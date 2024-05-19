package com.mygdx.game.screens;


import com.mygdx.game.GdxTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class ScoreWriterTest {

    @Test
    public void writeScore() {
        String test_string = "Test 0";
        ScoreWriter.writeScore("Test", 0);
        assertTrue(ScoreWriter.readScores().contains(test_string));
    }
}