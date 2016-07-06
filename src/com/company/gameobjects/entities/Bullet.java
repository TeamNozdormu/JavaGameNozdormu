package com.company.gameobjects.entities;

import com.company.gameobjects.base.GameObject;
import com.company.graphics.Assets;
import com.company.gamestates.GameState;

public class Bullet extends GameObject {

    private static final int speedMultiplier = 5;
    private int bulletStrength;

    public Bullet(int x, int y, int strengthMultiplier) {
        super(x, y, Assets.bullet, speedMultiplier);
        this.setBulletStrength(1 * strengthMultiplier);
    }

    public int getBulletStrength() {
        return this.bulletStrength;
    }

    public void setBulletStrength(int bulletStrength) {
        this.bulletStrength = bulletStrength;
    }

    public static int getSpeedMultiplier() {
        return speedMultiplier;
    }

    @Override
    public void update() {
        this.getColliderBox().setBounds(this.getX(), this.getY(),
                this.getObjectIcon().getWidth(), this.getObjectIcon().getHeight());
        this.setY(this.getY() - this.getSpeed() * speedMultiplier);

        if (this.getY() == 0) {
            GameState.getBulletsList().remove(this);
        }
    }

}