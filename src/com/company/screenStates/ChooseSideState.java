package com.company.screenStates;

import com.company.game.concreteObjects.Button;
import com.company.graphics.Assets;

import java.awt.*;

public class ChooseSideState extends State {

    //TODO: Display the menu with options and listen for the event clicked
    public Rectangle archerButton = new Rectangle(50, 300, 300, 100);
    public Rectangle mageButton = new Rectangle(450, 300, 300, 100);
    public static Button backButton = new Button(300, 480, Assets.button, "Back");

    public ChooseSideState() {

    }

    @Override
    public void update() {

    }

    public void display(Graphics g) {
        g.drawImage(Assets.chooseSide, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("redensek", Font.PLAIN, 40));
        g.setColor(Color.GREEN);
        g2d.draw(archerButton);
        g2d.draw(mageButton);
        backButton.display(g);

    }

}