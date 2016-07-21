package com.company.gameobjects.factory;

import com.company.gameobjects.base.Enemy;
import com.company.gameobjects.entities.EasyEnemy;
import com.company.gameobjects.entities.SturdyEnemy;
import com.company.interfaces.Createable;

/**
 * Created by ivanof on 7/20/16.
 */
public class Factory implements Createable{

    @Override
    public Enemy createEasyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        return new EasyEnemy(x, y, healthPoints, speedMultiplier);
    }

    @Override
    public Enemy createSturdyEnemy(int x, int y, int healthPoints, int speedMultiplier){
        return new SturdyEnemy(x, y, healthPoints, speedMultiplier);
    }

}
