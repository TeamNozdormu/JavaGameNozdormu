package com.company.game.concreteObjects;

import com.company.game.AbstractObjects.GameObject;
import com.company.graphics.Assets;
import com.company.screenStates.GameState;

public class Bullet extends GameObject {

    private int bulletStrength;
    private static final int speedMultiplier = 5;

    public Bullet(int x, int y, int strengthMultiplier) {
        super(x, y, Assets.bullet, speedMultiplier);
        this.bulletStrength = 1;
        this.bulletStrength *= strengthMultiplier;
    }

    public int GetBulletStrength() {
        return this.bulletStrength;
    }

    @Override
    public void update() {
        this.getColliderBox().setBounds(this.getX(), this.getY(),
                this.getObjectIcon().getWidth(), this.getObjectIcon().getHeight());
        this.setY(this.getY() - this.getSpeed() * speedMultiplier);

        if (this.getY() == 0) {
            GameState.bulletsList.remove(this);
        }
    }

}
