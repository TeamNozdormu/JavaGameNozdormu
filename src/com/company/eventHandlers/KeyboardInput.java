package com.company.eventHandlers;

import com.company.graphics.Assets;
import com.company.graphics.Display;
import com.company.game.Game;
import com.company.screenStates.GameOverState;
import com.company.screenStates.GameState;
import com.company.screenStates.MainMenuState;
import com.company.screenStates.StateManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    Game game;

    public KeyboardInput(Game game, Display display) {
        this.game = game;
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            GameState.player.isMovingRight = true;

        } else if (key == KeyEvent.VK_LEFT) {
            GameState.player.isMovingLeft = true;
        } else if (key == KeyEvent.VK_UP) {
            GameState.player.isMovingUp = true;
        } else if (key == KeyEvent.VK_DOWN) {
            GameState.player.isMovingDown = true;
        } else if (key == KeyEvent.VK_BACK_SPACE) {

        }

        if (key == KeyEvent.VK_SPACE && GameState.player.isFiring == false) {
            GameState.player.isFiring = true;
            PlayMusic.fire.play();
        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            GameState.player.isMovingRight = false;
        } else if (key == KeyEvent.VK_LEFT) {
            GameState.player.isMovingLeft = false;
        } else if (key == KeyEvent.VK_UP) {
            GameState.player.isMovingUp = false;
        } else if (key == KeyEvent.VK_DOWN) {
            GameState.player.isMovingDown = false;
        } else if (key == KeyEvent.VK_BACK_SPACE) {

        }

        if (key == KeyEvent.VK_SPACE && GameState.player.isFiring == true) {
            GameState.player.isFiring = false;
        }
        if (StateManager.getCurrentState() instanceof GameOverState) {
            if (key>='A' && key<='Z' && GameOverState.sb.length() < 14) {
                GameOverState.sb.append((char) key);
            } else if (key == KeyEvent.VK_BACK_SPACE && GameOverState.sb.length() > 0) {
                GameOverState.sb.deleteCharAt(GameOverState.sb.length() - 1);
            } else if (key == KeyEvent.VK_ENTER && GameOverState.sb.length() > 0) {
                GameState.player.setPlayerName(GameOverState.sb.toString());
                GameOverState.sb.setLength(0);
                Assets.savingHighScores(GameState.player.getPlayerName(), GameState.score);
                StateManager.setCurrentState(new MainMenuState());
            }
        }

    }

}
