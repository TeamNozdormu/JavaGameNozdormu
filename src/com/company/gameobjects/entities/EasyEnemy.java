package com.company.gameobjects.entities;

import com.company.gameobjects.base.Enemy;
import com.company.graphics.Assets;

public class EasyEnemy extends Enemy {

    private static final int HEALTH = 1;
    private static final int POINTS_FOR_PLAYER = 5;
    private static final int SPEED_MULTIPLIER = 3;

    //number of enemies that were not destroyed and passed. If player missed three enemies lose one life.
    public EasyEnemy(int x, int y) {
        super(x, y, HEALTH, Assets.easyEnemyInit, POINTS_FOR_PLAYER, SPEED_MULTIPLIER);
    }

}
