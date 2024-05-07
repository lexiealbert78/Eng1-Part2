package com.mygdx.game.screens;



import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.HesHustle;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainGameScreenTest {

    public MainGameScreenTest(OrthogonalTiledMapRenderer mapRenderer) {
    }

    @BeforeAll
            public static void setUp() {
                HesHustle game = Mockito.mock(HesHustle.class);
                MainGameScreen mainGameScreen = new MainGameScreen(game);
            }


            @Test
            public void testMapLoading() {
                assertEquals("map/GameWorld.tmx", MainGameScreen.getMapName());
            }
            /*
            @Test
            public void testLoadCamera() {
                mainGameScreen.loadCamera();
                assertEquals(0, mainGameScreen.getCamera().position.x, 0.01);
                assertEquals(0, mainGameScreen.getCamera().position.y, 0.01);
            }

            @Test
            public void testRender() {
                Gdx.gl = Mockito.mock(GL20.class);

                mainGameScreen.setBatch(batch);
                mainGameScreen.setImg(img);
                mainGameScreen.setMap(map);

                mainGameScreen.render();

                Mockito.verify(batch).begin();
                Mockito.verify(batch).draw(img, 0, 0);
                Mockito.verify(batch).end();
            }

            @Test
            public void testPlayerMovements() {
                mainGameScreen.loadPlayer();
                mainGameScreen.movePlayer(10, 10);
                assertEquals(10, mainGameScreen.getPlayer().getX(), 0.01);
                assertEquals(10, mainGameScreen.getPlayer().getY(), 0.01);
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
