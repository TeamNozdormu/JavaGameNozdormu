package com.company.eventHandlers;

import com.company.graphics.Display;
import com.company.screenStates.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    public static boolean isMage;

    public MouseInput(Display display) {
        display.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if (StateManager.getCurrentState() instanceof MainMenuState) {
            //Play Button
            if (MainMenuState.playButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ChooseClassState());
            }

            //High Scores Button
            if (MainMenuState.highScoreButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new HighScoresState());
            }

            //Quit Button
            if (MainMenuState.quitButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new QuitState());

                // TODO: Saving to file
                System.exit(0);
            }
        } else if (StateManager.getCurrentState() instanceof ChooseClassState) {
            //Sith Button
            if (mouseX >= 50 && mouseX <= 350) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.music.loop();
                    isMage = false;
                    StateManager.setCurrentState(new GameState());
                }
            }

            //Rebels Button
            if (mouseX >= 450 && mouseX <= 750) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.music.loop();
                    isMage = true;
                    StateManager.setCurrentState(new GameState());
                }
            }
            if (ChooseClassState.backButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        }

        // HighScores
        if (StateManager.getCurrentState() instanceof HighScoresState) {
            // Back Button
            if (HighScoresState.backButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}