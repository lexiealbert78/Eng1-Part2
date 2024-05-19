package com.mygdx.game.screens;

import com.mygdx.game.GdxTestRunner;
import com.mygdx.game.HesHustle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class UsernameScreenTest {

    @Test
    public void testGetPlayerName() {
        HesHustle game = Mockito.mock(HesHustle.class);
        UsernameScreen usernameScreen = new UsernameScreen(game);
        assertEquals("", usernameScreen.getPlayerName());
    }
}
