package com.company.gamestates;

import com.company.gameobjects.entities.Button;
import com.company.graphics.Assets;

import java.awt.*;

public class ChooseDifficultyState extends State {
    private static Button backButtonn = new Button(300, 420, Assets.button, "Back");
    private Rectangle easyButtor = new Rectangle(330, 210, 135, 50);
    private Rectangle mediumButton = new Rectangle(330, 275, 135, 50);
    private Rectangle hardButton = new Rectangle(330, 340, 135, 50);

    public ChooseDifficultyState() {

    }

    public static Button getBackButton() {
        return backButtonn;
    }

    public Rectangle getEasyButtor() {
        return this.easyButtor;
    }

    public void setEasyButtor(Rectangle easyButtor) {
        this.easyButtor = easyButtor;
    }

    public Rectangle getMediumButton() {
        return mediumButton;
    }

    public void setMediumButton(Rectangle mediumButton) {
        this.mediumButton = mediumButton;
    }

    public Rectangle getHardButton() {
        return this.hardButton;
    }

    public void setHardButton(Rectangle hardButton) {
        this.hardButton = hardButton;
    }

    @Override
    public void update() {

    }

    public void display(Graphics g) {

        g.drawImage(Assets.backgroundDifficulty, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("Immortal", Font.PLAIN, 25));
        g.setColor(Color.orange);
        g2d.draw(easyButtor);
        g2d.draw(mediumButton);
        g2d.draw(hardButton);
        backButtonn.display(g);
    }
}