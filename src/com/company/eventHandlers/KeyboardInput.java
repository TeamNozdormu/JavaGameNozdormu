package com.company.eventHandlers;

import com.company.gameobjects.Game;
import com.company.gameobjects.entities.Player;
import com.company.gamestates.GameOverState;
import com.company.gamestates.GameState;
import com.company.gamestates.MainMenuState;
import com.company.gamestates.StateManager;
import com.company.graphics.utililies.Assets;
import com.company.graphics.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.company.gameobjects.entities.Player.isMovingLeft;

public class KeyboardInput implements KeyListener {

    private Game game;

    public KeyboardInput(Game game, Display display) {
        this.setGame(game);
        display.getCanvas().addKeyListener(this);
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            Player.isMovingRight = true;
        } else if (key == KeyEvent.VK_LEFT) {
            isMovingLeft = true;
        } else if (key == KeyEvent.VK_UP) {
            GameState.getPlayer().isMovingUp = true;
        } else if (key == KeyEvent.VK_DOWN) {
            GameState.getPlayer().isMovingDown = true;
        } else if (key == KeyEvent.VK_BACK_SPACE) {

        }

        if (key == KeyEvent.VK_SPACE && GameState.getPlayer().isFiring == false) {
            GameState.getPlayer().isFiring = true;
            PlayMusic.fire.play();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            GameState.getPlayer().isMovingRight = false;
        } else if (key == KeyEvent.VK_LEFT) {
            GameState.getPlayer().isMovingLeft = false;
        } else if (key == KeyEvent.VK_UP) {
            GameState.getPlayer().isMovingUp = false;
        } else if (key == KeyEvent.VK_DOWN) {
            GameState.getPlayer().isMovingDown = false;
        } else if (key == KeyEvent.VK_BACK_SPACE) {

        }

        if (key == KeyEvent.VK_SPACE && GameState.getPlayer().isFiring == true) {
            GameState.getPlayer().isFiring = false;
        }
        if (StateManager.getCurrentState() instanceof GameOverState) {
            if (key >= 'A' && key <= 'Z' && GameOverState.getStringBuilder().length() < 14) {
                GameOverState.getStringBuilder().append((char) key);
            } else if (key == KeyEvent.VK_BACK_SPACE && GameOverState.getStringBuilder().length() > 0) {
                GameOverState.getStringBuilder().deleteCharAt(GameOverState.getStringBuilder().length() - 1);
            } else if (key == KeyEvent.VK_ENTER && GameOverState.getStringBuilder().length() > 0) {
                GameState.getPlayer().setPlayerName(GameOverState.getStringBuilder().toString());
                GameOverState.getStringBuilder().setLength(0);
                Assets.savingHighScores(GameState.getPlayer().getPlayerName(), GameState.getScore());
                StateManager.setCurrentState(new MainMenuState());
            }
        }
    }
}
