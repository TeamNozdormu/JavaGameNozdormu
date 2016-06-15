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

        g.setColor(Color.white);

        g.setFont(new Font("Immortal", Font.PLAIN, 50));
        g.drawImage(Assets.gameover, 0, 0, null);
        g.drawString("GAME OVER", 200, 200);

        g.setFont(new Font("Immortal", Font.PLAIN, 40));
        g.drawString("Please enter your name:", 180, 350);
        g.drawRect(260, 370, 280, 40);
        g.drawString(sb.toString(), 265, 405);

    }

}
