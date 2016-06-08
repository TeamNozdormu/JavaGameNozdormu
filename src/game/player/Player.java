package game.player;

import game.menu.StatusMenu;

import java.util.Objects;

public class Player extends Personality implements PersonalityType {
    private String playerName;
    private Type type;
    private int health;
    private int experience;
    private int attack;
    private int defence;
    private boolean isUser = false;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        //TODO validation
    }

    public void setHealth(int health) {
        this.health = Personality.HEALTH_DEFAULT;
        if (isUser) {
            this.health += health;
        }
    }

    public void setExperience(int experience) {
        this.experience = Personality.EXPERIENCE_DEFAULT;
        if (isUser) {
            this.experience += experience;
        }
    }

    public void setAttack(int attack) {
        this.attack = Personality.ATTACK_DEFAULT;
        if (isUser) {
            this.attack += attack;
        }
    }

    public void setDefence(int defence) {
        this.defence = Personality.DEFENCE_DEFAULT;
        if (isUser) {
            this.defence += defence;
        }
    }

    public Player(String playerName, StatusMenu status, Type type) {
        this.setPlayerName(playerName);
        this.setType(type);
        this.setHealth(50);
        this.setExperience(5);
        this.setAttack(15);
        this.setDefence(15);
    }

    @Override
    public void setType(Type type) {
        this.type = type;
        if (Objects.equals(this.type, Type.USER)) {
            this.isUser = true;
        }
    }
}
