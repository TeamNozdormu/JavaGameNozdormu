package com.company.eventhandlers;

import com.company.eventhandlers.utilities.PlayMusic;
import com.company.gameobjects.GameImpl;
import com.company.gameobjects.entities.PlayerImpl;
import com.company.gamestates.GameStateImpl;
import com.company.gamestates.utilities.StateManager;
import com.company.gamestates.menustates.gameplay.GameOverState;
import com.company.gamestates.menustates.main.MainMenuStateImpl;
import com.company.graphics.utililies.Assets;
import com.company.graphics.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.company.gameobjects.entities.PlayerImpl.isMovingLeft;

public class KeyboardInput implements KeyListener {

    private GameImpl game;

    public KeyboardInput(GameImpl game, Display display) {
        this.setGame(game);
        display.getCanvas().addKeyListener(this);
    }

    public GameImpl getGame() {
        return this.game;
    }

    public void setGame(GameImpl game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            PlayerImpl.isMovingRight = true;
        } else if (key == KeyEvent.VK_LEFT) {
            isMovingLeft = true;
        } else if (key == KeyEvent.VK_UP) {
            GameStateImpl.getPlayer().isMovingUp = true;
        } else if (key == KeyEvent.VK_DOWN) {
            GameStateImpl.getPlayer().isMovingDown = true;
        } else if (key == KeyEvent.VK_BACK_SPACE) {

        }

        if (key == KeyEvent.VK_SPACE && GameStateImpl.getPlayer().isFiring == false) {
            GameStateImpl.getPlayer().isFiring = true;
            PlayMusic.fire.play();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            GameStateImpl.getPlayer().isMovingRight = false;
        } else if (key == KeyEvent.VK_LEFT) {
            GameStateImpl.getPlayer().isMovingLeft = false;
        } else if (key == KeyEvent.VK_UP) {
            GameStateImpl.getPlayer().isMovingUp = false;
        } else if (key == KeyEvent.VK_DOWN) {
            GameStateImpl.getPlayer().isMovingDown = false;
        } else if (key == KeyEvent.VK_BACK_SPACE) {

        }

        if (key == KeyEvent.VK_SPACE && GameStateImpl.getPlayer().isFiring == true) {
            GameStateImpl.getPlayer().isFiring = false;
        }
        if (StateManager.getCurrentState() instanceof GameOverState) {
            if (key >= 'A' && key <= 'Z' && GameOverState.getStringBuilder().length() < 14) {
                GameOverState.getStringBuilder().append((char) key);
            } else if (key == KeyEvent.VK_BACK_SPACE && GameOverState.getStringBuilder().length() > 0) {
                GameOverState.getStringBuilder().deleteCharAt(GameOverState.getStringBuilder().length() - 1);
            } else if (key == KeyEvent.VK_ENTER && GameOverState.getStringBuilder().length() > 0) {
                GameStateImpl.getPlayer().setPlayerName(GameOverState.getStringBuilder().toString());
                GameOverState.getStringBuilder().setLength(0);
                Assets.savingHighScores(GameStateImpl.getPlayer().getPlayerName(), GameStateImpl.getScore());
                StateManager.setCurrentState(new MainMenuStateImpl());
            }
        }
    }
}
