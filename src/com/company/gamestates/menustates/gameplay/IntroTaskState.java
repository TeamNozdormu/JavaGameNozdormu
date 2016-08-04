package com.company.gamestates.menustates.gameplay;

import com.company.gamestates.AbstractState;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class IntroTaskState extends AbstractState {

    public void display(Graphics g) {
        g.drawImage(Assets.introTask, 0, 0, null);
    }
}
