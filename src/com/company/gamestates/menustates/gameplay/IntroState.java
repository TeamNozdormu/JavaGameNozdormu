package com.company.gamestates.menustates.gameplay;

import com.company.gamestates.AbstractState;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class IntroState extends AbstractState {

    public void display(Graphics g) {
        g.drawImage(Assets.intro, 0, 0, null);
    }
}
