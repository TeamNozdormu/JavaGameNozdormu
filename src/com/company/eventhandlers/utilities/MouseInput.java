package com.company.eventhandlers.utilities;

import com.company.gamestates.GameStateImpl;
import com.company.gamestates.menustates.gameplay.GainLevelState;
import com.company.gamestates.menustates.gameplay.IntroState;
import com.company.gamestates.menustates.gameplay.IntroTaskState;
import com.company.gamestates.menustates.main.*;
import com.company.gamestates.menustates.main.ChooseSideStateImpl;
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

        if (StateManager.getCurrentState() instanceof MainMenuStateImpl) {
            //Play Button
            if (MainMenuStateImpl.getPlayButton().getColliderBox().contains(mouseX, mouseY)) {
                //            StateManager.setCurrentState(new ChooseSideStateImpl());
                StateManager.setCurrentState(new ChooseDifficultyStateImpl());
            }

            //High Scores Button
            if (MainMenuStateImpl.getHighScoreButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new HighScoresStateImpl("Descending"));
            }

            //Quit Button
            if (MainMenuStateImpl.getQuitButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new QuitState());

                // TODO: Saving to file
                System.exit(0);
            }
        } else if (StateManager.getCurrentState() instanceof ChooseDifficultyStateImpl) {
            //Easy Button
            if (mouseX >= 330 && mouseX <= 460) {
                if (mouseY >= 210 && mouseY <= 260) {
                    isEasyButton = true;
                    StateManager.setCurrentState(new ChooseSideStateImpl());
                }
            }

            //Medium Button
            if (mouseX >= 330 && mouseX <= 460) {
                if (mouseY >= 275 && mouseY <= 325) {
                    isMediumButton = true;
                    StateManager.setCurrentState(new ChooseSideStateImpl());
                }
            }

            //Hard Button
            if (mouseX >= 330 && mouseX <= 460) {
                if (mouseY >= 350 && mouseY <= 400) {
                    isHardButton = true;
                    StateManager.setCurrentState(new ChooseSideStateImpl());
                }
            }

            if (ChooseDifficultyStateImpl.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuStateImpl());
            }
        } else if (StateManager.getCurrentState() instanceof ChooseSideStateImpl) {
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
            if (ChooseSideStateImpl.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ChooseDifficultyStateImpl());
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
                    StateManager.setCurrentState(new GameStateImpl());
                }
            }
        }

        //gain level
        else if (StateManager.getCurrentState() instanceof GainLevelState) {
            //Next, start game
            if (mouseX >= 250 && mouseX <= 560) {
                if (mouseY >= 520 && mouseY <= 600) {
                    PlayMusic.archer.loop();

                    StateManager.setCurrentState(new GameStateImpl());

                }
            }
        }
        // HighScores
        if (StateManager.getCurrentState() instanceof HighScoresStateImpl) {
            // Back Button
            if (HighScoresStateImpl.getBackButton().getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuStateImpl());
            } else if (HighScoresStateImpl.getReverseButton().getColliderBox().contains(mouseX, mouseY)) {
                ((HighScoresStateImpl) StateManager.getCurrentState()).reverseOrder();
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
} else if(StateManager.getCurrentState() instanceof ChooseDifficultyStateImpl) {
                //Easy Button
                if (mouseX >= 330 && mouseX <= 460) {
                    if (mouseY >= 210 && mouseY <= 260) {
                        isEasyBotton = true;
                        isHardBotton = false;
                        isMediumBotton = false;
                        // StateManager.setCurrentState(new GameStateImpl());
                        StateManager.setCurrentState(new IntroState());
                    }
                }

                //Medium Button
                if (mouseX >= 330 && mouseX <= 460) {
                    if (mouseY >= 275 && mouseY <= 325) {
                        isEasyBotton = false;
                        isHardBotton = false;
                        isMediumBotton = true;
                        //    StateManager.setCurrentState(new GameStateImpl());
                        StateManager.setCurrentState(new IntroState());
                    }
                }

                //Hard Button
                if (mouseX >= 330 && mouseX <= 460) {
                    if (mouseY >= 350 && mouseY <= 400) {
                        isEasyBotton = false;
                        isHardBotton = true;
                        isMediumBotton = false;
                        //    StateManager.setCurrentState(new GameStateImpl());
                        StateManager.setCurrentState(new IntroState());
                    }
                }
 */