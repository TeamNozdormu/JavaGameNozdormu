package com.company.gamestates;

import com.company.gameobjects.entities.Button;
import com.company.graphics.Assets;

import java.awt.*;

public class MainMenuState extends State {

    //TODO: Display the menu with options and listen for the event clicked
    private static Button playButton = new Button(-220, 300, Assets.button, "play");
    private static Button highScoreButton = new Button(-220, 400, Assets.button, "High scores");
    private static Button quitButton = new Button(-220, 500, Assets.button, "Quit");

    private int currentSelection;
    private int playButtonXPos;
    private int highScoresButtonXPos;
    private int quitButtonXPos;

    public MainMenuState() {
        this.setPlayButtonXPos(-220);
        this.setHighScoresButtonXPos(-220);
        this.setQuitButtonXPos(-220);

        playButton.setX(this.getPlayButtonXPos());
        highScoreButton.setX(this.getHighScoresButtonXPos());
        quitButton.setX(this.getQuitButtonXPos());
    }

    public static Button getPlayButton() {
        return playButton;
    }

    public static void setPlayButton(Button playButton) {
        MainMenuState.playButton = playButton;
    }

    public static Button getHighScoreButton() {
        return highScoreButton;
    }

    public static void setHighScoreButton(Button highScoreButton) {
        MainMenuState.highScoreButton = highScoreButton;
    }

    public static Button getQuitButton() {
        return quitButton;
    }

    public static void setQuitButton(Button quitButton) {
        MainMenuState.quitButton = quitButton;
    }

    public int getCurrentSelection() {
        return currentSelection;
    }

    public void setCurrentSelection(int currentSelection) {
        this.currentSelection = currentSelection;
    }

    public int getPlayButtonXPos() {
        return playButtonXPos;
    }

    private void setPlayButtonXPos(int playButtonXPos) {
        this.playButtonXPos = playButtonXPos;
    }

    public int getHighScoresButtonXPos() {
        return highScoresButtonXPos;
    }

    private void setHighScoresButtonXPos(int highScoresButtonXPos) {
        this.highScoresButtonXPos = highScoresButtonXPos;
    }

    public int getQuitButtonXPos() {
        return quitButtonXPos;
    }

    private void setQuitButtonXPos(int quitButtonXPos) {
        this.quitButtonXPos = quitButtonXPos;
    }

    @Override
    public void update() {

        if (this.getPlayButtonXPos() < 90) {
            this.setPlayButtonXPos(this.getPlayButtonXPos() + 10);
            playButton.setX(this.getPlayButtonXPos());
        } else if (this.getHighScoresButtonXPos() < 90) {
            this.setHighScoresButtonXPos(this.getHighScoresButtonXPos() + 10);
            highScoreButton.setX(this.getHighScoresButtonXPos());
        } else if (this.getQuitButtonXPos() < 90) {
            this.setQuitButtonXPos(this.getQuitButtonXPos() + 10);
            quitButton.setX(this.getQuitButtonXPos());
        }

        playButton.update();
        highScoreButton.update();
        quitButton.update();
    }

    public void display(Graphics g) {

        g.drawImage(Assets.mainMenuBackground, 0, 0, null);

        Font titleFont = new Font("redensek", Font.BOLD, 55);
        g.setFont(titleFont);
        g.setColor(Color.green);
        g.drawString("Space Invasion!", 350, 100);

        Font buttonsFont = new Font("redensek", Font.BOLD, 33);
        g.setFont(buttonsFont);
        g.drawImage(Assets.buttonBar, -185, playButton.getY() + 35, null);
        playButton.display(g);
        g.drawImage(Assets.buttonBar, -185, highScoreButton.getY() + 35, null);
        highScoreButton.display(g);
        g.drawImage(Assets.buttonBar, -185, quitButton.getY() + 35, null);
        quitButton.display(g);
        }
        }