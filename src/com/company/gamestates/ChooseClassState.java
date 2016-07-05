package com.company.gamestates;

import com.company.gameobjects.entities.Button;
import com.company.graphics.Assets;

import java.awt.*;

public class ChooseClassState extends State {

    public static Button backButton = new Button(300, 480, Assets.button, "Back");
    //TODO: Display the menu with options and listen for the event clicked
    public Rectangle archerButtor = new Rectangle(50, 300, 300, 100);
    public Rectangle mageButton = new Rectangle(450, 300, 300, 100);

    public ChooseClassState() {

    }

    @Override
    public void update() {

    }

    public void display(Graphics g) {

        g.drawImage(Assets.chooseSide, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("Immortal", Font.PLAIN, 25));
        g.setColor(Color.white);
        g2d.draw(archerButtor);
        g2d.draw(mageButton);
        backButton.display(g);
    }

}