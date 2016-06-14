package com.company.screenStates;

import com.company.gameObjectsInterfaces.Displayable;
import com.company.graphics.Assets;

import java.awt.*;

public class GameOverState extends State implements Displayable {

    public static StringBuilder sb = new StringBuilder();

    @Override
    public void update() {

    }

    public void display(Graphics g) {

        g.setColor(Color.GREEN);

        g.setFont(new Font("redensek", Font.PLAIN, 100));
        g.drawImage(Assets.gameover, 0, 0, null);
        g.drawString("GAME OVER", 190, 300);

        g.setFont(new Font("redensek", Font.PLAIN, 40));
        g.drawString("Please enter your name:", 190, 350);
        g.drawRect(260, 370, 280, 40);
        g.drawString(sb.toString(), 265, 395);

    }

}
