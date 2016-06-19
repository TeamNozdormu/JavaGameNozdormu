package com.company.game.concreteObjects;

import com.company.Settings.PlayerSettings;
import com.company.game.AbstractObjects.Bonus;
import com.company.game.AbstractObjects.GameObject;
import com.company.graphics.Assets;
import com.company.screenStates.GameState;

import java.awt.image.BufferedImage;

public class Player extends GameObject  {
    private int numberOfLives;
    private String playerName;
    private int score;
    private Bonus currentBonus;
    private int timeForBonus;
    private int cropX, cropY;

    public static boolean
            isMovingLeft = false,
            isMovingRight = false,
            isMovingUp = false,
            isMovingDown = false,
            isFiring = false;

    public Player(int x, int y, String name, int speed) {
        super(x, y, Assets.player, speed);
        this.setPlayerName(name);
        this.setNumberOfLives(PlayerSettings.PLAYER_INITIAL_NUMBER_OF_LIVES);
        this.setScore(PlayerSettings.PLAYER_DEFAULT_SCORES);
    }

    public Player(BufferedImage bufferedImage) {
        super(bufferedImage);
    }

    @Override
    public void update() {

        //TODO problem with replace with getter and setter
        if(this.timeForBonus > 0) {
            this.timeForBonus--;
        } else if(this.currentBonus != null && this.timeForBonus == 0) {
            this.currentBonus = null;
        } else {
            this.currentBonus = null;
            this.timeForBonus = 0;
        }

        this.getColliderBox().setBounds(this.getX(), this.getY(),
                this.getObjectIcon().getWidth(), this.getObjectIcon().getHeight());

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

        if (isFiring) {
            if(this.getCurrentBonus() != null){
                GameState.bulletsList.add(new Bullet(this.getX() + 16, this.getY(), this.getCurrentBonus().getMultiplierForDamage()));
            } else {
                GameState.bulletsList.add(new Bullet(this.getX() + 16, this.getY(), 1));
            }

            isFiring = false;
        }

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

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
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

    public int getNumberOfLives() {
        return this.numberOfLives;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setCurrentBonus(Bonus bonus) {
        this.currentBonus = bonus;
        this.setTimeForBonus(bonus.getBonusDuration());
    }

    public Bonus getCurrentBonus() {
        return this.currentBonus;
    }

}
