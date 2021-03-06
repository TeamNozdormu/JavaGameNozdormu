package com.company.gameobjects.entities;

import com.company.gameobjects.interfaces.Player;
import com.company.gamestates.GameStateImpl;
import com.company.utilities.PlayerSettings;
import com.company.gameobjects.base.AbstractBonus;
import com.company.gameobjects.base.AbstractGameObject;
import com.company.graphics.utililies.Assets;

import java.awt.image.BufferedImage;

public class PlayerImpl extends AbstractGameObject implements Player {

    public static boolean
            isMovingLeft = false,
            isMovingRight = false,
            isMovingUp = false,
            isMovingDown = false,
            isFiring = false;

    private static int level = 1;
    private int numberOfLives;
    private String playerName;
    private int score;
    private AbstractBonus currentBonus;
    private int timeForBonus;

    public PlayerImpl(int x, int y, String name, int speed, int nextLevel) {
        super(x, y, Assets.player, speed);
        this.setPlayerName(name);
        this.setNumberOfLives(PlayerSettings.PLAYER_INITIAL_NUMBER_OF_LIVES);
        this.setScore(PlayerSettings.PLAYER_DEFAULT_SCORES);
    }

    public PlayerImpl(BufferedImage bufferedImage) {
        super(bufferedImage);
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        PlayerImpl.level = level;
    }

    public static void inceraseLevel() {
        level++;
    }

    public int getTimeForBonus() {
        return this.timeForBonus;
    }

    public void setTimeForBonus(int timeForBonus) {
        this.timeForBonus = timeForBonus;
    }

    public void addToScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumberOfLives() {
        return this.numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public AbstractBonus getCurrentBonus() {
        return this.currentBonus;
    }

    public void setCurrentBonus(AbstractBonus bonus) {
        this.currentBonus = bonus;
        this.setTimeForBonus(bonus.getBonusDuration());
    }

    @Override
    public void update() {
        if (this.timeForBonus > 0) {
            this.timeForBonus--;
        } else if (this.currentBonus != null && this.timeForBonus == 0) {
            this.currentBonus = null;
        } else {
            this.currentBonus = null;
            this.timeForBonus = 0;
        }

        movePlayer();
        handleFireAction();
    }

	private void handleFireAction() {
        if (isFiring) {
            if (this.getCurrentBonus() != null) {
                GameStateImpl.getBulletsList().add(
                        new BulletImpl(
                                this.getX() + 16,
                                this.getY(),
                                this.getCurrentBonus().getMultiplierForDamage()
                        )
                );
            } else {
                GameStateImpl.getBulletsList().add(
                        new BulletImpl(
                                this.getX() + 16,
                                this.getY(),
                                1
                        )
                );
            }

            isFiring = false;
        }
	}

	private void movePlayer() {
		this.getColliderBox().setBounds(
                this.getX(),
                this.getY(),
                this.getObjectIcon().getWidth(),
                this.getObjectIcon().getHeight()
        );

        if (isMovingRight && this.getX() + this.getSpeed() <= 730) {
            this.setX(this.getX() + this.getSpeed());
        }
        if (isMovingLeft && this.getX() + this.getSpeed() >= 0) {
            this.setX(this.getX() - this.getSpeed());
        }
        if (isMovingDown && this.getY() + this.getSpeed() < 520) {
            this.setY(this.getY() + this.getSpeed());
        }
        if (isMovingUp && this.getY() - this.getSpeed() >= 0) {
            this.setY(this.getY() - this.getSpeed());
        }
	}
}
