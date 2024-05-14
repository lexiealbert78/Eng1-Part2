package com.mygdx.game.screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.GdxTestRunner;
import com.mygdx.game.HesHustle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(GdxTestRunner.class)
public class MainGameScreenTest {


    @Test
    public void testMapLoading() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        assertEquals("map/GameWorld.tmx", MainGameScreen.getMapName());
    }

    @Test
    public void testPauseButtonPressed() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        // Simulate a button press
        mainGameScreen.render(0);

        // Assuming your button press logic is triggered by F key press
        when(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)).thenReturn(true);

        // Call render again to handle button press
        mainGameScreen.render(0);
        // Verify that the screen changes to the MainGameScreen
        verify(game).setScreen(any());
    }
 /*
    @Test
    public void testPlayerMovements() {
        HesHustle game = Mockito.mock(HesHustle.class);
        MainGameScreen mainGameScreen = new MainGameScreen(game);
        mainGameScreen.render(0);
        mainGameScreen.loadPlayer();
        mainGameScreen.movePlayer(10, 10);
        assertEquals(10, mainGameScreen.player_x);
        assertEquals(10, mainGameScreen.player_y);
    }
*/
            /*
            @Test
            public void testLoadCamera() {
                mainGameScreen.loadCamera();
                assertEquals(0, mainGameScreen.getCamera().position.x, 0.01);
                assertEquals(0, mainGameScreen.getCamera().position.y, 0.01);
            }




            @Test
            public void testLoadInteractions() {
                mainGameScreen.loadInteractions();
                // Add assertions here to test interactions loading
            }

            @Test
            public void testCameraMovements() {
                mainGameScreen.loadCamera();
                mainGameScreen.moveCamera(100, 100);
                assertEquals(100, mainGameScreen.getCamera().position.x, 0.01);
                assertEquals(100, mainGameScreen.getCamera().position.y, 0.01);
            }

            @Test
            public void testWalkingAnimations() {
                mainGameScreen.loadPlayer();
                mainGameScreen.getPlayer().walk();
                // Add assertions here to test walking animations
            }

            @Test
            public void testInteractionMarkers() {
                mainGameScreen.loadInteractions();
                mainGameScreen.updateInteractionMarkers();
                // Add assertions here to test interaction markers visibility
            }

            @Test
            public void testCreatingActivityInstances() {
                mainGameScreen.createActivityInstance(ActivityType.EXAMPLE);
                // Add assertions here to test creating activity instances
            }

            @Test
            public void testMusic() {
                mainGameScreen.playMusic("background_music.mp3");
                // Add assertions here to test music playback
            }

            @Test
            public void testBlockingOfTilesAndMap() {
                mainGameScreen.loadMap("map.tmx");
                mainGameScreen.blockTile(5, 5);
                assertEquals(true, mainGameScreen.isTileBlocked(5, 5));
            }

            @Test
            public void testDrawsEnergyBar() {
                mainGameScreen.loadPlayer();
                mainGameScreen.drawEnergyBar();
                // Add assertions here to test energy bar visibility
            }

            @Test
            public void testDrawsTime() {
                mainGameScreen.updateTime();
                // Add assertions here to test time display
            }

             */
        }
