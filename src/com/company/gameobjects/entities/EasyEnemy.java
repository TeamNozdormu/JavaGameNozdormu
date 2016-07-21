package com.company.gameobjects.entities;

import com.company.gameobjects.base.Enemy;
import com.company.graphics.Assets;

public class EasyEnemy extends Enemy {

    private static final int POINTS_FOR_PLAYER = 5;

    public EasyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        super(x, y, healthPoints, Assets.easyEnemyInit, POINTS_FOR_PLAYER, speedMultiplier);
    }

}
