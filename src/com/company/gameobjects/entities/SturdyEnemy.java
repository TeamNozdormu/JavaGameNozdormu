package com.company.gameobjects.entities;

import com.company.gameobjects.base.Enemy;
import com.company.graphics.Assets;

public class SturdyEnemy extends Enemy {

    private static final int POINTS_FOR_PLAYER = 10;

    public SturdyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        super(x, y, healthPoints, Assets.sturdyEnemyInit, POINTS_FOR_PLAYER, speedMultiplier);
    }
}
