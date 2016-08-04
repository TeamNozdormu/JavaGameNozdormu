package com.company.gamestates.menustates.gameplay;

import com.company.gameobjects.entities.Button;
import com.company.gamestates.AbstractState;
import com.company.gamestates.interfaces.ChooseClassState;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class ChooseClassStateImpl extends AbstractState implements ChooseClassState {

    private static Button backButton = new Button(300, 480, Assets.button, "Back");
    //TODO: Display the menu with options and listen for the event clicked
    private Rectangle archerButton;
    private Rectangle mageButton;

    public ChooseClassStateImpl() {
        this.setArcherButton(new Rectangle(50, 300, 300, 100));
        this.setMageButton(new Rectangle(450, 300, 300, 100));
    }

    public static Button getBackButton() {
        return backButton;
    }

    private static void setBackButton(Button backButton) {
        ChooseClassStateImpl.backButton = backButton;
    }

    public Rectangle getArcherButton() {
        return this.archerButton;
    }

    private void setArcherButton(Rectangle archerButton) {
        this.archerButton = archerButton;
    }

    public Rectangle getMageButton() {
        return this.mageButton;
    }

    private void setMageButton(Rectangle mageButton) {
        this.mageButton = mageButton;
    }

    public void display(Graphics g) {
        g.drawImage(Assets.chooseSide, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(new Font("Immortal", Font.PLAIN, 25));
        g.setColor(Color.white);
        g2d.draw(archerButton);
        g2d.draw(mageButton);
        backButton.display(g);
    }
}