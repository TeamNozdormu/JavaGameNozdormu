package com.company.gamestates;

import com.company.gameobjects.entities.Button;
import com.company.graphics.Assets;

import java.awt.*;

public class ChooseSideState extends State {

    //TODO: Display the menu with options and listen for the event clicked
    private static Button backButton = new Button(300, 480, Assets.button, "Back");
    private Rectangle archerButton = new Rectangle(50, 300, 300, 100);
    private Rectangle mageButton = new Rectangle(450, 300, 300, 100);

    public ChooseSideState() {

    }

    public static Button getBackButton() {
        return backButton;
    }

    public Rectangle getArcherButton() {
        return archerButton;
    }

    public void setArcherButton(Rectangle archerButton) {
        this.archerButton = archerButton;
    }

    public Rectangle getMageButton() {
        return mageButton;
    }

    public void setMageButton(Rectangle mageButton) {
        this.mageButton = mageButton;
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