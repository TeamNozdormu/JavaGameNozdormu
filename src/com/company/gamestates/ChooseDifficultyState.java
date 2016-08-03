package com.company.gamestates;

import com.company.gameobjects.entities.Button;
import com.company.graphics.utililies.Assets;

import java.awt.*;

public class ChooseDifficultyState extends State {

    private static Button backButton;
    private Rectangle easyButton;
    private Rectangle mediumButton;
    private Rectangle hardButton;

    public ChooseDifficultyState() {
        ChooseDifficultyState.setBackButton(new Button(300, 420, Assets.button, "Back"));
        this.setEasyButton(new Rectangle(330, 210, 135, 50));
        this.setMediumButton(new Rectangle(330, 275, 135, 50));
        this.setHardButton(new Rectangle(330, 340, 135, 50));
    }

    public static Button getBackButton() {
        return backButton;
    }

    private static void setBackButton(Button backButton) {
        ChooseDifficultyState.backButton = backButton;
    }

    public Rectangle getEasyButton() {
        return this.easyButton;
    }

    private void setEasyButton(Rectangle easyButton) {
        this.easyButton = easyButton;
    }

    public Rectangle getMediumButton() {
        return mediumButton;
    }

    private void setMediumButton(Rectangle mediumButton) {
        this.mediumButton = mediumButton;
    }

    public Rectangle getHardButton() {
        return this.hardButton;
    }

    private void setHardButton(Rectangle hardButton) {
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
        g2d.draw(easyButton);
        g2d.draw(mediumButton);
        g2d.draw(hardButton);
        backButton.display(g);
    }
}