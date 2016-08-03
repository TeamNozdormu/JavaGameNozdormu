package com.company.gameobjects.entities;

import com.company.gameobjects.base.Enemy;
import com.company.gameobjects.utilities.GameObjectConstants;
import com.company.graphics.utililies.Assets;
import com.company.utilities.RandomGenerator;

public class SturdyEnemy extends Enemy {
    public SturdyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        super(x, y, healthPoints, Assets.sturdyEnemyInit, RandomGenerator.getNextIntRandom(GameObjectConstants.STURDY_ENEMY_POINTS_FOR_PLAYER),
                speedMultiplier);
    }
}
