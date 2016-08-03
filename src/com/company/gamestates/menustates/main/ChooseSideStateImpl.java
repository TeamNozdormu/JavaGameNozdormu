package com.company.gamestates.menustates.main;

import com.company.gameobjects.entities.Button;
import com.company.gamestates.AbstractState;
import com.company.gamestates.interfaces.ChooseSideState;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class ChooseSideStateImpl extends AbstractState implements ChooseSideState {

    //TODO: Display the menu with options and listen for the event clicked
    private static Button backButton;
    private Rectangle archerButton;
    private Rectangle mageButton;

    public ChooseSideStateImpl() {
        ChooseSideStateImpl.setBackButton(new com.company.gameobjects.entities.Button(300, 480, Assets.button, "Back"));
        this.setArcherButton(new Rectangle(50, 300, 300, 100));
        this.setMageButton(new Rectangle(450, 300, 300, 100));
    }

    public static Button getBackButton() {
        return backButton;
    }

    private static void setBackButton(Button backButton) {
        ChooseSideStateImpl.backButton = backButton;
    }

    public Rectangle getArcherButton() {
        return archerButton;
    }

    private void setArcherButton(Rectangle archerButton) {
        this.archerButton = archerButton;
    }

    public Rectangle getMageButton() {
        return mageButton;
    }

    private void setMageButton(Rectangle mageButton) {
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