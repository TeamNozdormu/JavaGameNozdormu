package com.company.interfaces;

import com.company.gameobjects.base.Enemy;

/**
 * Created by ivanof on 7/20/16.
 */
public interface Createable {

    Enemy createEasyEnemy(int x, int y, int healthPoints, int speedMultiplier);

    Enemy createSturdyEnemy(int x, int y, int healthPoints, int speedMultiplier);
}
