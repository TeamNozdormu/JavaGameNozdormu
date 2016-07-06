package com.company.gamestates;

import com.company.graphics.Assets;

import java.awt.*;

/**
 * Created by Tedi.Noji on 7/5/2016.
 */
public class IntroTaskState extends State {

    @Override
    public void update() {

    }

    public void display(Graphics g) {
        g.drawImage(Assets.introTask, 0, 0, null);
    }
}
