package com.company.gamestates.menustates.gameplay;

import com.company.gamestates.AbstractState;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class GameOverState extends AbstractState {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void display(Graphics g) {

        g.setColor(Color.WHITE);

        g.setFont(new Font("redensek", Font.PLAIN, 100));
        g.drawImage(Assets.gameover, 0, 0, null);
        g.drawString("GAME OVER", 190, 300);

        g.setFont(new Font("redensek", Font.PLAIN, 40));
        g.drawString("Please enter your name:", 190, 350);
        g.drawRect(260, 370, 280, 40);
        g.drawString(GameOverState.getStringBuilder().toString(), 265, 395);

    }

}
