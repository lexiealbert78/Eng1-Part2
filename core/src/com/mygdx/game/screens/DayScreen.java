package com.mygdx.game.screens;

// Importing required libraries and classes
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
 * Class that represents the end of day summary
 * Displays information about what the player has done and the days remaining.
 */
public class DayScreen implements Screen {

    // Main game screen reference
    private final Screen MainGameScreen;

    // Main game instance reference
    private final HesHustle game;

    // Arrays to store counts of studying, recreational activities, and eating for each day
    private final int[] studyCounter;
    private final int[][] recCounter;
    private final int[][] eatCounter;

    //jc
    private final int[] streakAims;

    int day; // Current day

    private final BitmapFont font; // Font used for rendering text

    private SpriteBatch dayBatch;

    private Texture continueButton;
    private UsernameScreen usernameScreen;



    /**
     * DayScreen Constructor
     *
     * @param game Instance of main game
     * @param MainGameScreen Reference to the MainGameScreen
     * @param day Current day
     * @param studyCounter Array containing study counts for each day
     * changed by jc
     * @param recCounter Array containing recreational activity counts for each day (0=duck, 1=bench, 2=football)
     * @param streakAims Array containing streak aims passed at the end of the game
     *
     * @param eatCounter Array containing times meals are eaten for each day
     */
    public DayScreen(HesHustle game, Screen MainGameScreen, int day, int[] studyCounter, int[][] recCounter, int[][] eatCounter, int[] streakAims) {
        this.game = game;
        this.MainGameScreen = MainGameScreen;
        this.day = day;
        this.streakAims = streakAims;


        // Passing in activity counters to create day summary
        this.studyCounter = studyCounter;
        this.recCounter = recCounter;
        this.eatCounter = eatCounter;


        // Initialising rendering variables

        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(3);

        continueButton = new Texture("ContinueButton.png");

    }

    /**
     * Called when DayScreen becomes the active screen
     */
    @Override
    public void show() {
        // Not used
    }

    /**
     * render() function called every frame to render the screen.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        // Clear the screen with a black background
        ScreenUtils.clear(0, 0, 0, 1);
        dayBatch = new SpriteBatch();

        // Leave the DayScreen if F is pressed
        if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {

            // If there are days left of the game, set the MainGameScreen as the active screen.
            if (this.day != 7) {
                ((MainGameScreen) MainGameScreen).startGameTimer(0);

                // Set player position to game spawn point
                ((MainGameScreen) MainGameScreen).setPlayerPosition(
                        (int) com.mygdx.game.screens.MainGameScreen.SPAWN_POINT_X,
                        (int) com.mygdx.game.screens.MainGameScreen.SPAWN_POINT_Y);

                ((Game) Gdx.app.getApplicationListener()).setScreen(this.MainGameScreen);
            }
            // If there are no days left, create a new EndGameScreen and set it as active.
            else {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new EndGameScreen(this.game, studyCounter, recCounter, eatCounter, streakAims));

            }
        }

        // Begin Rendering frame
        dayBatch.begin();

        // Get the Width and Height of the screen to use for centering text
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        // Displays the text for what day it is.
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, "Dawn of");
        font.draw(dayBatch, layout, (screenWidth - layout.width) / 2, (float) (screenHeight * 0.95));

        GlyphLayout days_left = new GlyphLayout();
        GlyphLayout hours_left = new GlyphLayout();


        // Check what day it is and set the title accordingly
        if (day == 0){
            days_left.setText(font,  "The First Day");
        }
        if (day == 1){
            days_left.setText(font,  "The Second Day");
        }
        else if (day == 2){
            days_left.setText(font, "The Third Day");
        }
        else if (day == 3){
            days_left.setText(font, "The Fourth Day");
        }
        else if (day == 4){
            days_left.setText(font, "The Fifth Day");
        }
        else if (day == 5){
            days_left.setText(font, "The Sixth Day");
        }
        else if (day == 6){
            days_left.setText(font, "The Final Day");
        }
        else{
            days_left.setText(font, "The Exam Day");
        }

        // Set text for how many hours are remaining
        hours_left.setText(font, "-"+(24*(7 - day)) +" Hours Remain-");


        font.draw(dayBatch, days_left, (screenWidth - days_left.width) / 2, (float) (screenHeight * 0.85));
        font.draw(dayBatch, hours_left, (screenWidth - hours_left.width) / 2, (float) (screenHeight * 0.65));

        // Displays the summary for what the user did in the day
        GlyphLayout summary_title = new GlyphLayout();
        GlyphLayout study = new GlyphLayout();
        GlyphLayout eaten = new GlyphLayout();
        GlyphLayout rec = new GlyphLayout();

        summary_title.setText(font, "Summary for Day "+ day +":");
        study.setText(font, "Times Studied: "+studyCounter[day-1]);

        int countEat = 0;
        for (int time:eatCounter[day-1]){
            if (time != 0){
                countEat++;
            }
        }

        eaten.setText(font, "Times Eaten: " + countEat);
        rec.setText(font, "Recreational Activities:"+(recCounter[day-1][0]+recCounter[day-1][1]+recCounter[day-1][2]));

        // Draw text summaries to screen
        font.draw(dayBatch, summary_title, (screenWidth - 950) / 2, (float) (screenHeight * 0.75));
        font.draw(dayBatch, study, (screenWidth - 950) / 2, (float) (screenHeight * 0.55));
        font.draw(dayBatch, eaten, (screenWidth - 950) / 2, (float) (screenHeight * 0.45));
        font.draw(dayBatch, rec, (screenWidth - 950) / 2, (float) (screenHeight * 0.35));

        //jc- draw streak progress if changed that day
        GlyphLayout streak = new GlyphLayout();
        if (recCounter[day-1][0]>0) { //ducks
            streak.setText(font, "Duck streak progress made:" + Total("recduck") + " / " + ((MainGameScreen) MainGameScreen).StreakAim("recduck"));
            font.draw(dayBatch, streak, (screenWidth - 950) / 2, (float) (screenHeight * 0.27));
        }
        if (recCounter[day-1][1]>0) { //bench
            streak.setText(font, "Bench streak progress made:" + Total("recbench") + " / " + ((MainGameScreen) MainGameScreen).StreakAim("recbench"));
            font.draw(dayBatch, streak, (screenWidth - 950) / 2, (float) (screenHeight * 0.17));
        }
        if (recCounter[day-1][2]>0) { //football
            streak.setText(font, "Football streak progress made:" + Total("recfootball") + " / " + ((MainGameScreen) MainGameScreen).StreakAim("recfootball"));
            font.draw(dayBatch, streak, (screenWidth - 950) / 2, (float) (screenHeight * 0.07));
        }

        //Drawing the continue button
        dayBatch.draw(continueButton, (float) ((Gdx.graphics.getWidth() - continueButton.getWidth())/1.25), (float) ((Gdx.graphics.getHeight() - continueButton.getHeight())/8),continueButton.getWidth()*2,continueButton.getHeight()*2);

        // End rendering for frame
        dayBatch.end();

    }

    /**
     * sum counts for streak purposes --jc
     */
    public int Total(String label){
        int count = 0;
        int streak = 0;
        switch (label){
            case "recduck":
                for (int i = 0; i < 7; i++) {
                    count += recCounter[i][0];
                }
                streak = 0;
                break;
            case "recbench":
                for (int i = 0; i < 7; i++) {
                    count += recCounter[i][1];
                }
                streak = 1;
                break;
            case "recfootball":
                for (int i = 0; i < 7; i++) {
                    count += recCounter[i][2];
                }
                streak = 2;
                break;
        }
        return Math.min(count, streakAims[streak]);
    }

    @Override
    public void resize(int width, int height) {
        // Not used
    }

    @Override
    public void pause() {
        // Not used
    }

    @Override
    public void resume() {
        // Not used
    }

    @Override
    public void hide() {
        // Not used
    }

    @Override
    public void dispose() {
        // Not used
    }
}
