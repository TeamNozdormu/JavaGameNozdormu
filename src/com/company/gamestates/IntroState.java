package com.company.gamestates;

import com.company.graphics.Assets;

import java.awt.*;

public class IntroState extends State {

    @Override
    public void update() {

    }

    public void display(Graphics g) {
        g.drawImage(Assets.intro, 0, 0, null);
    }
}
