package com.company.eventhandlers.utilities;

import com.company.gamestates.GameState;
import com.company.gamestates.menustates.gameplay.GainLevelState;
import com.company.gamestates.menustates.gameplay.IntroState;
import com.company.gamestates.menustates.gameplay.IntroTaskState;
import com.company.gamestates.menustates.main.ChooseDifficultyState;
import com.company.gamestates.menustates.main.ChooseSideState;
import com.company.gamestates.menustates.main.HighScoresState;
import com.company.gamestates.menustates.main.MainMenuState;
import com.company.gamestates.menustates.main.QuitState;
import com.company.gamestates.utilities.StateManager;
import com.company.graphics.Display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class MouseInput implements MouseListener {

    public static boolean isMage;
    public static boolean isEasyButton = false;
    public static boolean isHardButton = false;
    public static boolean isMediumButton = false;

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
            if (MainMenuState.getPlayButton().getColliderBox().contains(mouseX, mouseY)) {
                //            StateManager.setCurrentState(new ChooseSideState());
                StateManager.setCurrentState(new ChooseDifficultyState());
            }

            //High Scores Button
            if (MainMenuState.getHighScoreButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new HighScoresState("Descending"));
            }

            //Quit Button
            if (MainMenuState.getQuitButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new QuitState());

                // TODO: Saving to file
                System.exit(0);
            }
        } else if (StateManager.getCurrentState() instanceof ChooseDifficultyState) {
            //Easy Button
            if (mouseX >= 330 && mouseX <= 460) {
                if (mouseY >= 210 && mouseY <= 260) {
                    isEasyButton = true;
                    StateManager.setCurrentState(new ChooseSideState());
                }
            }

            //Medium Button
            if (mouseX >= 330 && mouseX <= 460) {
                if (mouseY >= 275 && mouseY <= 325) {
                    isMediumButton = true;
                    StateManager.setCurrentState(new ChooseSideState());
                }
            }

            //Hard Button
            if (mouseX >= 330 && mouseX <= 460) {
                if (mouseY >= 350 && mouseY <= 400) {
                    isHardButton = true;
                    StateManager.setCurrentState(new ChooseSideState());
                }
            }

            if (ChooseDifficultyState.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        } else if (StateManager.getCurrentState() instanceof ChooseSideState) {
            //Archer Button
            if (mouseX >= 50 && mouseX <= 350) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.archer.loop();
                    isMage = false;
                    StateManager.setCurrentState(new IntroState());
                }
            }

            //Mage Button
            if (mouseX >= 450 && mouseX <= 750) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.mage.loop();
                    isMage = true;
                    StateManager.setCurrentState(new IntroState());
                }
            }
            if (ChooseSideState.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ChooseDifficultyState());
            }
        } else if (StateManager.getCurrentState() instanceof IntroState) {
            //Next
            if (mouseX >= 450) {
                if (mouseY >= 550) {
                    PlayMusic.archer.loop();
                    StateManager.setCurrentState(new IntroTaskState());
                }
            }
        } else if (StateManager.getCurrentState() instanceof IntroTaskState) {
            //Next, start game
            if (mouseX >= 250 && mouseX <= 560) {
                if (mouseY >= 520 && mouseY <= 600) {
                    PlayMusic.archer.loop();
                    StateManager.setCurrentState(new GameState());
                }
            }
        }

        //gain level
        else if (StateManager.getCurrentState() instanceof GainLevelState) {
            //Next, start game
            if (mouseX >= 250 && mouseX <= 560) {
                if (mouseY >= 520 && mouseY <= 600) {
                    PlayMusic.archer.loop();

                    StateManager.setCurrentState(new GameState());

                }
            }
        }
        // HighScores
        if (StateManager.getCurrentState() instanceof HighScoresState) {
            // Back Button
            if (HighScoresState.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            } else if (HighScoresState.getReverseButton().getColliderBox().contains(mouseX, mouseY)) {
                ((HighScoresState) StateManager.getCurrentState()).reverseOrder();
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


/*
} else if(StateManager.getCurrentState() instanceof ChooseDifficultyState) {
                //Easy Button
                if (mouseX >= 330 && mouseX <= 460) {
                    if (mouseY >= 210 && mouseY <= 260) {
                        isEasyBotton = true;
                        isHardBotton = false;
                        isMediumBotton = false;
                        // StateManager.setCurrentState(new GameState());
                        StateManager.setCurrentState(new IntroState());
                    }
                }

                //Medium Button
                if (mouseX >= 330 && mouseX <= 460) {
                    if (mouseY >= 275 && mouseY <= 325) {
                        isEasyBotton = false;
                        isHardBotton = false;
                        isMediumBotton = true;
                        //    StateManager.setCurrentState(new GameState());
                        StateManager.setCurrentState(new IntroState());
                    }
                }

                //Hard Button
                if (mouseX >= 330 && mouseX <= 460) {
                    if (mouseY >= 350 && mouseY <= 400) {
                        isEasyBotton = false;
                        isHardBotton = true;
                        isMediumBotton = false;
                        //    StateManager.setCurrentState(new GameState());
                        StateManager.setCurrentState(new IntroState());
                    }
                }
 */