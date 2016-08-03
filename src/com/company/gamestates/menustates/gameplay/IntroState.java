package com.company.gamestates.menustates.gameplay;

import com.company.gamestates.State;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class IntroState extends State {

    @Override
    public void update() {

    }

    public void display(Graphics g) {
        g.drawImage(Assets.intro, 0, 0, null);
    }
}
