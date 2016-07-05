package com.company.gamestates;

import com.company.interfaces.Displayable;
import com.company.graphics.Assets;

import java.awt.*;

public class GameOverState extends State implements Displayable {

    private static StringBuilder sb = new StringBuilder();

    public static StringBuilder getSb() {
        return sb;
    }

    @Override
    public void update() {

    }

    public void display(Graphics g) {

        g.setColor(Color.WHITE);

        g.setFont(new Font("redensek", Font.PLAIN, 100));
        g.drawImage(Assets.gameover, 0, 0, null);
        g.drawString("GAME OVER", 190, 300);

        g.setFont(new Font("redensek", Font.PLAIN, 40));
        g.drawString("Please enter your name:", 190, 350);
        g.drawRect(260, 370, 280, 40);
        g.drawString(sb.toString(), 265, 395);

    }

}
