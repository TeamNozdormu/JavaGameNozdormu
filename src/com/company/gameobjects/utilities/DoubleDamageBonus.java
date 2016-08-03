package com.company.gameobjects.utilities;

import com.company.gameobjects.base.AbstractBonus;
import com.company.graphics.utililies.Assets;

public final class DoubleDamageBonus extends AbstractBonus {

    private static final int DAMAGE_MULTIPLIER = 2;
    private static final int SPEED_MULTIPLIER = 3;
    private static final int SCORE_MULTIPLIER = 2;
    private static final int BONUS_DURATION = 60;

    public DoubleDamageBonus(int x, int y) {
        super(x, y,
                Assets.doubleDamageBonus,
                DAMAGE_MULTIPLIER,
                SPEED_MULTIPLIER,
                SCORE_MULTIPLIER,
                BONUS_DURATION
        );
    }

}
