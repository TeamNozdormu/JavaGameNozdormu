package com.company.gamestates.menuStates.gameplayMenuStates;

import com.company.gamestates.State;
import com.company.graphics.utililies.Assets;
import com.company.interfaces.Displayable;

import java.awt.*;

public class GameOverState extends State implements Displayable {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static StringBuilder getStringBuilder() {
        return stringBuilder;
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
        g.drawString(GameOverState.getStringBuilder().toString(), 265, 395);

    }

}
