package com.company.game.concreteObjects;

import com.company.game.AbstractObjects.Bonus;
import com.company.graphics.Assets;

public class DoubleDamageBonus extends Bonus {

    private static final int DAMAGE_MULTIPLIER = 2;
    private static final int SPEED_MULTIPLIER = 3;
    private static final int SCORE_MULTIPLIER = 2;
    private static final int BONUS_DURATION = 60;

    public DoubleDamageBonus(int x, int y) {
        super(x, y, Assets.doubleDamageBonus, DAMAGE_MULTIPLIER, SPEED_MULTIPLIER, SCORE_MULTIPLIER, BONUS_DURATION);
    }

}
