package com.company.screenStates;

import com.company.game.concreteObjects.Button;
import com.company.graphics.Assets;

import java.awt.*;

public class MainMenuState extends State {

    //TODO: Display the menu with options and listen for the event clicked
    private int currentSelection;

    public static Button playButton = new Button(-220, 300, Assets.button, "play");
    public static Button highScoreButton = new Button(-220, 400, Assets.button, "High scores");
    public static Button quitButton = new Button(-220, 500, Assets.button, "Quit");

    private int playButtonXPos;
    private int highScoresButtonXPos;
    private int quitButtonXPos;

    public MainMenuState() {

        playButtonXPos = -220;
        highScoresButtonXPos = -220;
        quitButtonXPos = -220;
        playButton.setX(playButtonXPos);
        highScoreButton.setX(highScoresButtonXPos);
        quitButton.setX(quitButtonXPos);

    }

    @Override
    public void update() {

        if(playButtonXPos < 90) {
            playButtonXPos += 10;
            playButton.setX(playButtonXPos);
        } else if (highScoresButtonXPos < 90) {
            highScoresButtonXPos += 10;
            highScoreButton.setX(highScoresButtonXPos);
        } else if(quitButtonXPos < 90) {
            quitButtonXPos += 10;
            quitButton.setX(quitButtonXPos);
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