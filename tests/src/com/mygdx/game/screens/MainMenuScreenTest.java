package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.mygdx.game.GdxTestRunner;
import com.mygdx.game.HesHustle;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;
@RunWith(GdxTestRunner.class)
public class MainMenuScreenTest {

    private static MainMenuScreen mainMenuScreen;
    private static MainGameScreen mainGameScreen;

    @Before
    public void setup() {
        HesHustle game = Mockito.mock(HesHustle.class);
        mainGameScreen = Mockito.mock(MainGameScreen.class);
        mainMenuScreen = new MainMenuScreen(game, mainGameScreen);
    }

    @Test
    public void testResize() {
        // Simulate a mouse click within the play button bounds
        int width = mainMenuScreen.fullButtonTexture.getWidth();
        System.out.println(width);
        mainMenuScreen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        // Verify that setScreen is called with expected arguments
        assertNotEquals(width, mainMenuScreen.fullButtonTexture.getWidth());
    }


}
