package com.company.gamestates;

import com.company.graphics.Assets;
import com.company.interfaces.Displayable;

import java.awt.*;

public class GainLevelState extends State implements Displayable {

    @Override
    public void update() {

    }

    public void display(Graphics g) {
        g.drawImage(Assets.gainLevel, 0, 0, null);
    }
}
