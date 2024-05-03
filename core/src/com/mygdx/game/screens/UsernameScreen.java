package com.mygdx.game.screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.HesHustle;

public class UsernameScreen implements Screen {

    private final HesHustle game;
    private final Stage stage;
    private final Texture background;
    private final Texture continueButton;
    private final TextField nameTextField;

    public UsernameScreen(HesHustle game, MainGameScreen gameScreen) {
        this.game = game;

        // Create the stage with a viewport
        stage = new Stage(new ScreenViewport());

        // Load resources
        background = new Texture("endScreenBackground.png");
        continueButton = new Texture("ContinueButton.png");

        // Create the text field
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        nameTextField = new TextField("", new TextField.TextFieldStyle(font, Color.BLACK, null, null, null));

        // Add actors to the stage
        stage.addActor(nameTextField);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Check if F is pressed to return to Main Menu screen
        if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            if (game != null) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainGameScreen(game));
            }
        }

        // Draw the background and other elements
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        GlyphLayout title = new GlyphLayout();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2);
        title.setText(font, "Enter your username:");
        font.setColor(Color.BLACK);
        font.draw(stage.getBatch(), title, (Gdx.graphics.getWidth() - title.width) / 2, (Gdx.graphics.getHeight() * 0.85f));

        stage.getBatch().draw(continueButton, (Gdx.graphics.getWidth() - continueButton.getWidth()) / 1.15f,
                (Gdx.graphics.getHeight() - continueButton.getHeight()) / 10f, continueButton.getWidth() * 2,
                continueButton.getHeight() * 2);
        stage.getBatch().end();

        // Update and draw the stage
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
