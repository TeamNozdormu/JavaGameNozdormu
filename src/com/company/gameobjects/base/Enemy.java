package com.company.gameobjects.base;

import com.company.gameobjects.entities.DoubleDamageBonus;
import com.company.helperclasses.RandomGenerator;
import com.company.gamestates.GameState;

import java.awt.image.BufferedImage;

public abstract class Enemy extends GameObject {
    public static int passed = 0;
    private int health;
    private int pointsForPlayer;

    public Enemy(int x, int y, int health, BufferedImage gameObjectIcon, int pointsForPlayer, int speedMultiplier) {
        super(x, y, gameObjectIcon, speedMultiplier);
        this.health = health;
        this.pointsForPlayer = pointsForPlayer;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPointsForPlayer() {
        return this.pointsForPlayer;
    }

    @Override
    public void update() {
        this.getColliderBox().setBounds(
                this.getX(),
                this.getY(),
                this.getObjectIcon().getWidth(),
                this.getObjectIcon().getHeight()
        );

        if (this.getHealth() > 0) {
            this.getColliderBox().setBounds(
                    this.getX(),
                    this.getY(),
                    this.getObjectIcon().getWidth(),
                    this.getObjectIcon().getHeight()
            );
            this.setY(this.getY() + this.getSpeed());

            //enemy is outside the window
            if (this.getY() > 650) {
                GameState.getEnemiesList().remove(this);
                passed++;
            }

            for (int i = 0; i < GameState.getBulletsList().size(); i++) {
                if (this.collide(GameState.getBulletsList().get(i).getColliderBox())) {
                    this.health -= GameState.getBulletsList().get(i).getBulletStrength();
                    if (this.health < 0) {
                        this.health = 0;
                        if (GameState.getPlayer().getCurrentBonus() != null) {
                            this.pointsForPlayer *= GameState.getPlayer().getCurrentBonus().getMultiplierForScore();
                        }
                    }

                    GameState.getBulletsList().remove(i);
                }
            }
        }

        if (this.getHealth() == 0) {
            GameState.getEnemiesList().remove(this);
            double chanceToGenerateBonus = RandomGenerator.getNextRandom();

            if (chanceToGenerateBonus > 0.8) {
                GameState.getBonusList().add(new DoubleDamageBonus(this.getX(), this.getY()));
            }

            if (GameState.getPlayer().getCurrentBonus() != null) {
                GameState.score += this.getPointsForPlayer() * GameState.getPlayer().getCurrentBonus().getMultiplierForScore();
            } else {
                GameState.score += this.getPointsForPlayer();
            }
        }
    }
}