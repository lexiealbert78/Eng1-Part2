package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.HesHustle;

/**
 * Screen used to show the leaderboard to the user from the menu.
 * (added as part of assessment 2)
 */
public class LeaderboardScreen implements Screen {

    private final BitmapFont font; // Font used for rendering text
    private final SpriteBatch leaderboardBatch; //SpriteBatch used to render screen
    private final HesHustle game; // Main Game instance reference
    private final Texture background; // Background art of screen
    private Texture continueButton; // Continue button

    public LeaderboardScreen(HesHustle game) {
        this.game = game;

        // Initialise SpriteBatch for rendering
        leaderboardBatch = new SpriteBatch();

        // Setting font for rendering text
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2); // Adjust the scale as needed

        // Setting background artwork and continue button textures
        //Leaderboard uses the same background as endScreen
        background = new Texture("endScreenBackground.png");
        continueButton = new Texture("ContinueButton.png");


    }

    @Override
    public void show() {
        //Not used
    }

    @Override
    public void render(float v) {
        // Clear screen
        ScreenUtils.clear(0, 0, 0, 1);

        // Check if F is pressed, and if so return to Main Menu screen
        if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen(this.game, null));
        }

        // Get the Width and Height of the screen to use for centering text
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        // Set text layouts
        GlyphLayout title = new GlyphLayout();
        title.setText(font, "Leaderboard");

        //glyphlayout for name and score associated with it



        // Render the screen background
        leaderboardBatch.begin();
        leaderboardBatch.draw(background, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw the text on the screen
        font.draw(leaderboardBatch, title, (screenWidth - title.width) / 2, (float) (screenHeight*0.85));


        leaderboardBatch.draw(continueButton, (float) ((Gdx.graphics.getWidth() - continueButton.getWidth())/1.15), (float) ((Gdx.graphics.getHeight() - continueButton.getHeight())/10),continueButton.getWidth()*2,continueButton.getHeight()*2);

        leaderboardBatch.end();

    }

    @Override
    public void resize(int i, int i1) {
    //Not used
    }

    @Override
    public void pause() {
    //Not used
    }

    @Override
    public void resume() {
    //Not used
    }

    @Override
    public void hide() {
    //Not used
    }

    @Override
    public void dispose() {
        leaderboardBatch.dispose();
        font.dispose();
        background.dispose();
    }
}
