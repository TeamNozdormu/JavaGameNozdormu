package com.company.interfaces;

import com.company.gameobjects.base.AbstractEnemy;

/**
 * Created by ivanof on 7/20/16.
 */
public interface Createable {

    AbstractEnemy createEasyEnemy(int x, int y, int healthPoints, int speedMultiplier);

    AbstractEnemy createSturdyEnemy(int x, int y, int healthPoints, int speedMultiplier);
}
