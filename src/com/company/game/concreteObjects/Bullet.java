package com.company.game.concreteObjects;

import com.company.game.AbstractObjects.GameObject;
import com.company.graphics.Assets;
import com.company.screenStates.GameState;

public class Bullet extends GameObject {

    private int bulletStrenght;
    private static final int speedMultiplier = 5;

    public Bullet(int x, int y, int strenghtMultiplier) {

        super(x, y, Assets.bullet, speedMultiplier);
        this.bulletStrenght = 1;
        this.bulletStrenght *= strenghtMultiplier;

    }

    public int GetBulletStrength() {
        return this.bulletStrenght;
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
