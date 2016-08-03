package com.company.gamestates.menustates.main;

import com.company.gameobjects.entities.Button;
import com.company.gamestates.AbstractState;
import com.company.gamestates.interfaces.MainMenuState;
import com.company.graphics.utililies.Assets;
import com.company.utilities.GameSettings;

import java.awt.*;

public class MainMenuStateImpl extends AbstractState implements MainMenuState {

    private static Button playButton;
    private static Button highScoreButton;
    private static Button quitButton;

    private int currentSelection;
    private int playButtonXPos;
    private int highScoresButtonXPos;
    private int quitButtonXPos;

    public MainMenuStateImpl() {
        MainMenuStateImpl.setPlayButton(new Button(-220, 300, Assets.button, "play"));
        MainMenuStateImpl.setHighScoreButton(new Button(-220, 400, Assets.button, "High scores"));
        MainMenuStateImpl.setQuitButton(new Button(-220, 500, Assets.button, "Quit"));

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

    private static void setPlayButton(Button playButton) {
        MainMenuStateImpl.playButton = playButton;
    }

    public static Button getHighScoreButton() {
        return highScoreButton;
    }

    private static void setHighScoreButton(Button highScoreButton) {
        MainMenuStateImpl.highScoreButton = highScoreButton;
    }

    public static Button getQuitButton() {
        return quitButton;
    }

    private static void setQuitButton(Button quitButton) {
        MainMenuStateImpl.quitButton = quitButton;
    }

    public int getCurrentSelection() {
        return currentSelection;
    }

    private void setCurrentSelection(int currentSelection) {
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

        Font titleFont = new Font("redensek", Font.BOLD, 45);
        g.setFont(titleFont);
        g.setColor(Color.GREEN);
        g.drawString(GameSettings.GAME_NAME, 100, 100);

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