package com.company.gamestates.menuStates.gameplayMenuStates;

import com.company.gameobjects.entities.Button;
import com.company.gamestates.State;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class ChooseClassState extends State {

    private static Button backButton = new Button(300, 480, Assets.button, "Back");
    //TODO: Display the menu with options and listen for the event clicked
    private Rectangle archerButton;
    private Rectangle mageButton;

    public ChooseClassState() {
        this.setArcherButton(new Rectangle(50, 300, 300, 100));
        this.setMageButton(new Rectangle(450, 300, 300, 100));
    }

    public static Button getBackButton() {
        return backButton;
    }

    private static void setBackButton(Button backButton) {
        ChooseClassState.backButton = backButton;
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

    @Override
    public void update() {

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