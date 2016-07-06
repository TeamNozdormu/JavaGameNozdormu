package com.company.eventHandlers;

import com.company.gamestates.*;
import com.company.graphics.Display;

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

        if(StateManager.getCurrentState() instanceof MainMenuState) {
            //Play Button
            if(MainMenuState.getPlayButton().getColliderBox().contains(mouseX, mouseY)){
                StateManager.setCurrentState(new ChooseSideState());
            }

            //High Scores Button
            if (MainMenuState.getHighScoreButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new HighScoresState());
            }

            //Quit Button
            if (MainMenuState.getQuitButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new QuitState());

                // TODO: Saving to file
                System.exit(0);
            }
        }
        else if(StateManager.getCurrentState() instanceof ChooseSideState) {
            //Archer Button
            if (mouseX >= 50 && mouseX <= 350) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.archer.loop();
                    isMage = false;
                    // StateManager.setCurrentState(new GameState());
                    StateManager.setCurrentState(new IntroState());
                }
            }

            //Mage Button
            if (mouseX >= 450 && mouseX <= 750) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.mage.loop();
                    isMage = true;
                    //    StateManager.setCurrentState(new GameState());
                    StateManager.setCurrentState(new IntroState());
                }
            }
            if (ChooseSideState.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        }
            else if(StateManager.getCurrentState() instanceof IntroState) {
                //Next
                if (mouseX >= 450 ) {
                    if (mouseY >= 550 ) {
                        PlayMusic.archer.loop();
                        StateManager.setCurrentState(new IntroTaskState());
                    }
                }
        }

        else if(StateManager.getCurrentState() instanceof IntroTaskState) {
            //Next, start game
            if (mouseX >= 250 && mouseX <= 560) {
                if (mouseY >= 520 && mouseY <= 600) {
                    PlayMusic.archer.loop();
                    StateManager.setCurrentState(new GameState());
                }
            }
        }

        //gain level
        else if(StateManager.getCurrentState() instanceof GainLevelState) {
            //Next, start game
            if (mouseX >= 250 && mouseX <= 560) {
                if (mouseY >= 520 && mouseY <= 600) {
                    PlayMusic.archer.loop();

                    StateManager.setCurrentState(new GameState());

                }
            }
        }
        // HighScores
        if(StateManager.getCurrentState() instanceof HighScoresState) {
            // Back Button
            if(HighScoresState.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
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