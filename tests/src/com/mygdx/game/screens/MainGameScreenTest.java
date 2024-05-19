package com.mygdx.game.screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GdxTestRunner;
import com.mygdx.game.HesHustle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.Timer;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(GdxTestRunner.class)
public class MainGameScreenTest {


    @Test
    public void testPlayerMovementsX() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        float X = MainGameScreen.GetPlayerX();
        mainGameScreen.handleMovement(100, 100);
        assertNotEquals(X + 100, MainGameScreen.GetPlayerX());
    }

    @Test
    public void testPlayerMovementsY() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        float Y = MainGameScreen.GetPlayerY();
        mainGameScreen.handleMovement(100, 100);
        assertNotEquals(Y + 100, MainGameScreen.GetPlayerY());
    }

    @Test
    public void TestStreakAimDuck() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        int duck = mainGameScreen.StreakAim("recduck");
        assertEquals(6, duck);
    }

    @Test
    public void TestStreakAimBench() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        int bench = mainGameScreen.StreakAim("recbench");
        assertEquals(3, bench);
    }

    @Test
    public void TestStreakAimBall() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        int ball = mainGameScreen.StreakAim("");
        assertEquals(5, ball);
    }

    @Test
    public void TestStartGameTimer() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        mainGameScreen.startGameTimer(0);
        Timer timer = mainGameScreen.timer;
        assertNotEquals(null, timer);
    }

    @Test
    public void TestStopGameTimer() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        mainGameScreen.startGameTimer(0);
        mainGameScreen.stopGameTimer();
        Timer timer = mainGameScreen.timer;
        assertEquals(null, timer);
    }

    @Test
    public void TestActivityPlayerClose() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        Texture markersPNG = new Texture(Gdx.files.internal("Markers.png"));
        TextureRegion[][] tmpMarkers = TextureRegion.split(markersPNG, markersPNG.getWidth() / 4, markersPNG.getHeight());
        TextureRegion recreationMarker = tmpMarkers[0][0];
        Activity activity = new Activity("recfootball", 1158, 585, -30, 60, recreationMarker, 1);
        assertTrue(activity.isPlayerClose(1158, 585));

    }

}
