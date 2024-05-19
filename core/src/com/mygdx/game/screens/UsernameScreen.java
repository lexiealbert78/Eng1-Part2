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
    private Stage stage;
    private final Texture background;
    private final Texture continueButton;
    private final TextField nameTextField;
    private String playerName;

    public UsernameScreen(HesHustle game) {
        this.game = game;
        this.playerName = null;

        // Create the stage with a viewport


        // Load resources
        background = new Texture("endScreenBackground.png");
        continueButton = new Texture("ContinueButton.png");

        // Create the text field
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        nameTextField = new TextField("", new TextField.TextFieldStyle(font, Color.BLACK, null, null, null));
        float x = (Gdx.graphics.getWidth() - nameTextField.getWidth()) / 2;
        float y = (Gdx.graphics.getHeight() - nameTextField.getHeight()) / 2;
        nameTextField.setPosition(x, y);


        // Add actors to the stage

    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        stage.addActor(nameTextField);
        Gdx.input.setInputProcessor(stage);
        // Set the text field to be focused
        stage.setKeyboardFocus(nameTextField);
    }

    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Check if F is pressed to return to Main Menu screen
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            playerName = nameTextField.getText();
            UsernameManager.getInstance().setUsername(playerName);
            if (game != null) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainGameScreen(game));
            }
        }

        // Draw the background and other elements
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw "Enter your username" message
        GlyphLayout title = new GlyphLayout();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2);
        font.setColor(Color.BLACK);
        title.setText(font, "Enter your username:");
        font.draw(stage.getBatch(), title, (Gdx.graphics.getWidth() - title.width) / 2, (Gdx.graphics.getHeight() * 0.85f));

        // Draw "Press Enter to Continue" message
        GlyphLayout continueMessage = new GlyphLayout();
        continueMessage.setText(font, "Press Enter to Continue to Game");
        font.draw(stage.getBatch(), continueMessage, (Gdx.graphics.getWidth() - continueMessage.width) / 2, (Gdx.graphics.getHeight() * 0.3f));

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

    public String getPlayerName(){
        return playerName != null ? playerName : ""; // Return playerName if not null, otherwise return an empty string
    }




}
