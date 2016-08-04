package com.company.gamestates.menustates.gameplay;

import com.company.gamestates.AbstractState;
import com.company.graphics.utililies.Assets;
import com.company.gamestates.interfaces.Displayable;

import java.awt.*;

public class GainLevelState extends AbstractState implements Displayable {

    @Override
    public void update() {

    }

    public void display(Graphics g) {
        g.drawImage(Assets.gainLevel, 0, 0, null);
    }
}
