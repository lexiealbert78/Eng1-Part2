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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import java.util.Arrays;




/**
 * Screen used to show the final score to the user at the end of the game.
 */
public class EndGameScreen implements Screen {


    private final BitmapFont font; // Font used for rendering text
    private final SpriteBatch scoreSummaryBatch; //SpriteBatch used to render screen
    private final HesHustle game; // Main Game instance reference
    private final Texture background; // Background art of screen
    private Texture continueButton; // Continue button


    private int score = 0; // Players game score
    private int percentScore;
    // Arrays to store counts each activity for each day
    private final int[] studyCounter;
    private final int[][] recCounter;
    private final int[][] eatCounter;
    private final int[] streakAims;



  // Variables to store amount of times activities were done
    private int timesEaten;
    private int studyCount;
    private int daysStudied;
    private int recCount;
    private int maxPoints;


    /**
     * Constructor for EndGameScreen class
     *
     * @param game Game instance
     * @param studyCounter Array containing study counts for each day
     * changed by jc
     * @param recCounter Array containing recreational activity counts for each day (0=duck, 1=bench, 2=football)
     * @param streakAims Array containing streak aims passed at the end of the game
     *
     * @param eatCounter Array containing times meals are eaten for each day
     */
    public EndGameScreen(HesHustle game, int[] studyCounter, int[][] recCounter, int[][] eatCounter, int[] streakAims) {
        this.game = game;
        this.studyCounter = studyCounter;
        this.recCounter = recCounter;
        this.eatCounter = eatCounter;
        this.streakAims = streakAims;

        // Initialise SpriteBatch for rendering
        scoreSummaryBatch = new SpriteBatch();

        // Setting font for rendering text
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2); // Adjust the scale as needed

        // Setting background artwork and continue button textures
        background = new Texture("endScreenBackground.png");
        continueButton = new Texture("ContinueButton.png");


        calculateScore();

    }
    /**
     * Function called when EndGameScreen becomes the active screen.
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
        GlyphLayout gameOver = new GlyphLayout();
        gameOver.setText(font, "Game Over!");

        GlyphLayout finalScore = new GlyphLayout();
        GlyphLayout passFail = new GlyphLayout();

        // Convert points into score from 0-100
        percentScore = (int)(((double)score / maxPoints) * 100);

        // Make sure new score is between 0 and 100
        if (percentScore < 0){
            percentScore = 0;
        }
        if (percentScore > 100){
            percentScore = 100;
        }

        finalScore.setText(font, "Final Score: " + percentScore+" / 100");

        if (percentScore < 40){
            passFail.setText(font, "Fail");
        }
        else{
            passFail.setText(font, "Pass");
        }

        GlyphLayout summary = new GlyphLayout();
        GlyphLayout totalStudy = new GlyphLayout();
        GlyphLayout totalDaysStudy = new GlyphLayout();
        GlyphLayout totalRec = new GlyphLayout();
        GlyphLayout totalEat = new GlyphLayout();
        GlyphLayout streak = new GlyphLayout();

        summary.setText(font, "Total Amount of: ");
        totalStudy.setText(font, "Times Studied = "+studyCount);
        totalDaysStudy.setText(font, "Days Studied = "+daysStudied);
        totalRec.setText(font, "Recreation Activities = "+recCount);
        totalEat.setText(font, "Times Ate = "+timesEaten);

        // Render the screen background
        scoreSummaryBatch.begin();
        scoreSummaryBatch.draw(background, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw the text on the screen
        font.draw(scoreSummaryBatch, gameOver, (screenWidth - gameOver.width) / 2, (float) (screenHeight*0.85));
        font.draw(scoreSummaryBatch, finalScore, (screenWidth - finalScore.width) / 2, (float) (screenHeight*0.8));
        font.draw(scoreSummaryBatch, passFail, (screenWidth - passFail.width) / 2, (float) (screenHeight*0.72));

        //jc-- achievements
        font.getData().setScale(1.75f); // Adjust the scale as needed
        if (StreakDone("recduck")){
            streak.setText(font, "ACHIEVEMENT: Quack Connoisseur!");
            font.draw(scoreSummaryBatch, streak, (screenWidth - streak.width) / 2, (float) (screenHeight*0.63));
        }
        if (StreakDone("recbench")){
            streak.setText(font, "ACHIEVEMENT: Bench Buddy Badge!");
            font.draw(scoreSummaryBatch, streak, (screenWidth - streak.width) / 2, (float) (screenHeight*0.57));
        }
        if (StreakDone("recfootball")){
            streak.setText(font, "ACHIEVEMENT: On a Roll!");
            font.draw(scoreSummaryBatch, streak, (screenWidth - streak.width) / 2, (float) (screenHeight*0.51));
        }
        font.getData().setScale(2); // Adjust the scale as needed

        font.draw(scoreSummaryBatch, summary, (screenWidth - summary.width) / 2, (float) (screenHeight*0.41));
        font.draw(scoreSummaryBatch, totalStudy, (screenWidth - totalStudy.width) / 2, (float) (screenHeight*0.32));
        font.draw(scoreSummaryBatch, totalDaysStudy, (screenWidth - totalDaysStudy.width) / 2, (float) (screenHeight*0.23));
        font.draw(scoreSummaryBatch, totalRec, (screenWidth - totalRec.width) / 2, (float) (screenHeight*0.14));
        font.draw(scoreSummaryBatch, totalEat, (screenWidth - totalEat.width) / 2, (float) (screenHeight*0.05));

        scoreSummaryBatch.draw(continueButton, (float) ((Gdx.graphics.getWidth() - continueButton.getWidth())/1.15), (float) ((Gdx.graphics.getHeight() - continueButton.getHeight())/10),continueButton.getWidth()*2,continueButton.getHeight()*2);


        scoreSummaryBatch.end();

        //if users score is higher than top 10 on leaderboard, write to
        //leaderboard, else do nothing with it
        //ScoreWriter.writeScore(nameTextField.getText(), percentScore);


    }

    /**
     * streaks done? --jc
     */
    private boolean StreakDone(String label) {
        int count = 0;
        int aim = 10;
        switch (label) {
            case "recduck":
                for (int i = 0; i < 7; i++) {
                    count += recCounter[i][0];
                }
                aim = streakAims[0];
                break;
            case "recbench":
                for (int i = 0; i < 7; i++) {
                    count += recCounter[i][1];
                }
                aim = streakAims[1];
                break;
            case "recfootball":
                for (int i = 0; i < 7; i++) {
                    count += recCounter[i][2];
                }
                aim = streakAims[2];
                break;
        }
        return (count >= aim);
    }

    /**
     * Calculates the score using defined rules/logic
     */
    public void calculateScore(){

        /*
         * Studying gives the player points
         * Score increases up to studying 10 times a week
         * Studying more than this will remove points from the player
         * There is a bonus for studying each day
         *
         * Maximum points:
         * - Studying (up to 10 times) = 10*10 = 100pts
         * - Bonus for studying every day (or 6 days + catchup) = 40 pts
         */

        // Number of times studied
        studyCount = Arrays.stream(studyCounter).sum();

        // Number of different days the player studied
        daysStudied = (int) ((int) 7 - (Arrays.stream(studyCounter).filter(num -> num == 0).count()));

        // Add points for number of times studied in the week
        if (studyCount <= 10){
            score += studyCount * 10;
        } else {
            score += 10 * 10;
            // Penalise over-studying
            score -= (studyCount-10) * 5;
        }

        // Bonus for working everyday
        if (daysStudied == 7){
            score += 40;
        } else if (daysStudied == 6) {
            if (studyCount > 6){
                // Checking if the player missed a day but caught up
                score += 40;
            }
        }



        /*
         * Eating gives the player points
         * More points are awarded if they eat 3 times a day
         * Bonus for eating 3 reasonably spaced meals a day
         *
         * Maximum points:
         * - Eating (3 times a day, reasonably spaced) = (3*5) + 5(bonus) = 20
         *      - *7 for the week = 30*7 = 140
         */

        int totalDays = eatCounter.length;
        int mealsPerDay = eatCounter[0].length;

        // Loop through each day to check logic
        for (int i = 0; i < totalDays; i++) {
            int mealsEaten = (int) Arrays.stream(eatCounter[i]).filter(num -> num != 0).count();

            switch (mealsEaten){
                // If the player didn't eat, penalise them
                case 0:
                    break;

                // If the player only ate once, reward a small amount of points
                case 1:
                    score += 5;
                    timesEaten++;
                    break;

                // If the player only ate twice, add more points
                case 2:
                    score += 10;
                    timesEaten += 2;
                    break;
                case 3:
                    // If the player ate 3 times, reward them more points
                    score += 15;
                    timesEaten += 3;

                    // Check if the player ate at reasonable intervals
                    if ((eatCounter[i][1] - eatCounter[i][0] > 240) && (eatCounter[i][2] - eatCounter[i][1] > 240)){
                        score += 5;
                    }
                    break;
            }
        }



        // Recreational activities = Good
        // Points every time
        // Bonus for doing it everyday
        //jc - variation increases score


        /*
         * Recreation gives score
         * Points are rewarded every time it is done but only up to 7 times
         *
         * Maximum points:
         * - activties (up to 7 times) = 7*9 + 7 bonus for variation = 70 pts
         */

        // Number of times recreational activity was done
        //changed by jc
        recCount = 0;
        int ducks = 0;
        int benches = 0;
        int footballs = 0;
        for (int i = 0; i < totalDays; i++) {
            recCount += recCounter[i][0] + recCounter[i][1] + recCounter[i][2];
            ducks += recCounter[i][0];
            benches += recCounter[i][1];
            footballs += recCounter[i][2];
        }

        // Points for doing recreational activities, only up to 7 times
        score += Math.min(recCount, 7) * 9;

        //jc -- variaton bonus of 7
        if (ducks>1 && benches>1 && footballs>1) score+=7;

        //streak bonus --jc
        if (StreakDone("recduck")) score+=50;
        if (StreakDone("recbench")) score+=50;
        if (StreakDone("recfootball")) score+=50;

        /*
         * Total Maximum points in a week =
         *  - Studying : 140
         *  - Eating : 140
         *  - Recreation : 70
         * changed by jc
         *  + 50 per achievement, giving a theoretical max of 500
         */

        this.maxPoints = 500;

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
        scoreSummaryBatch.dispose();
        font.dispose();
        background.dispose();
    }
}
