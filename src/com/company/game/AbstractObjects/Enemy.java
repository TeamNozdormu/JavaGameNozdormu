package com.company.game.AbstractObjects;

import com.company.game.concreteObjects.DoubleDamageBonus;
import com.company.helperClasses.RandomGenerator;
import com.company.screenStates.GameState;

import java.awt.image.BufferedImage;

public abstract class Enemy extends GameObject {

    private int health;
    private int pointsForPlayer;
    public static int passed = 0;

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

        this.getColliderBox().setBounds(this.getX(), this.getY(), this.getObjectIcon().getWidth(),
                this.getObjectIcon().getHeight());

        if (this.getHealth() > 0) {
            this.getColliderBox().setBounds(this.getX(), this.getY(), this.getObjectIcon().getWidth(),
                    this.getObjectIcon().getHeight());
            this.setY(this.getY() + this.getSpeed());

            //enemy is outside the window
            if (this.getY() > 650) {
                GameState.enemiesList.remove(this);
                passed++;
            }

            for (int i = 0; i < GameState.bulletsList.size(); i++) {
                if (this.collide(GameState.bulletsList.get(i).getColliderBox())) {
                    this.health -= GameState.bulletsList.get(i).GetBulletStrength();

                    if (this.health < 0) {
                        this.health = 0;
                        if (GameState.player.getCurrentBonus() != null) {
                            this.pointsForPlayer *= GameState.player.getCurrentBonus().getMultiploerForScore();
                        }
                    }

                    GameState.bulletsList.remove(i);
                }
            }
        }

        if (this.getHealth() == 0) {
            GameState.enemiesList.remove(this);
            double chanceToGenerateBonus = RandomGenerator.getNextRandom();

            if (chanceToGenerateBonus > 0.8) {
                GameState.bonusList.add(new DoubleDamageBonus(this.getX(), this.getY()));
            }

            if (GameState.player.getCurrentBonus() != null) {
                GameState.score += this.getPointsForPlayer() * GameState.player.getCurrentBonus().getMultiploerForScore();
            } else {
                GameState.score += this.getPointsForPlayer();
            }
        }

    }

}