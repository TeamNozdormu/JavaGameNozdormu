package com.company.gameobjects.entities;

import com.company.gameobjects.base.AbstractEnemy;
import com.company.gameobjects.utilities.GameObjectConstants;
import com.company.graphics.utililies.Assets;

public class EasyEnemy extends AbstractEnemy {
    public EasyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        super(x, y, healthPoints, Assets.easyEnemyInit, GameObjectConstants.EASY_ENEMY_POINTS_FOR_PLAYER, speedMultiplier);
    }
}
