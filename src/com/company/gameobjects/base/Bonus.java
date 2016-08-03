package com.company.gameobjects.base;

import com.company.gamestates.gameplayStates.GameState;
import com.company.graphics.utililies.Assets;

import java.awt.image.BufferedImage;

public abstract class Bonus extends GameObject {

    private int multiplierForDamage;
    private int multiplierForScore;
    private int bonusDuration;

    public Bonus(int x,
                 int y,
                 BufferedImage gameObjectIcon,
                 int damageMultiplier,
                 int speedMultiplier,
                 int multiplierForScore,
                 int bonusDuration) {
        super(x, y, Assets.doubleDamageBonus, speedMultiplier);
        this.setMultiplierForDamage(damageMultiplier);
        this.setMultiplierForScore(multiplierForScore);
        this.setBonusDuration(bonusDuration);

    }

    public int getMultiplierForDamage() {
        return this.multiplierForDamage;
    }

    private void setMultiplierForDamage(int multiplierForDamage) {
        this.multiplierForDamage = multiplierForDamage;
    }

    public int getMultiplierForScore() {
        return this.multiplierForScore;
    }

    private void setMultiplierForScore(int multiplierForScore) {
        this.multiplierForScore = multiplierForScore;
    }

    public int getBonusDuration() {
        return this.bonusDuration;
    }

    private void setBonusDuration(int bonusDuration) {
        this.bonusDuration = bonusDuration;
    }

    @Override
    public void update() {
        this.setY(this.getY() + this.getSpeed());
        this.getColliderBox().setBounds(
                this.getX(),
                this.getY(),
                this.getObjectIcon().getWidth(),
                this.getObjectIcon().getHeight()
        );

        if (this.collide(GameState.getPlayer().getColliderBox())) {
            GameState.getPlayer().setCurrentBonus(this);
            GameState.getBonusList().remove(this);
        }
    }
}