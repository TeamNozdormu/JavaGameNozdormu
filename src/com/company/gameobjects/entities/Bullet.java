package com.company.gameobjects.entities;

import com.company.gameobjects.base.GameObject;
import com.company.gameobjects.utilities.GameObjectConstants;
import com.company.gamestates.GameStateImpl;
import com.company.graphics.utililies.Assets;

public class Bullet extends GameObject {
    private int bulletStrength;

    public Bullet(int x, int y, int strengthMultiplier) {
        super(x, y, Assets.bullet, GameObjectConstants.BULLET_SPEED_MULTIPLIER);
        this.setBulletStrength(1 * strengthMultiplier);
    }

    public int getBulletStrength() {
        return this.bulletStrength;
    }

    public void setBulletStrength(int bulletStrength) {
        this.bulletStrength = bulletStrength;
    }

    @Override
    public void update() {
        this.getColliderBox().setBounds(
                this.getX(),
                this.getY(),
                this.getObjectIcon().getWidth(),
                this.getObjectIcon().getHeight()
        );
        this.setY(this.getY() - this.getSpeed() * GameObjectConstants.BULLET_SPEED_MULTIPLIER);

        if (this.getY() == 0) {
            GameStateImpl.getBulletsList().remove(this);
        }
    }

}
