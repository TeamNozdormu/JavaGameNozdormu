package game.players.classes;

import game.players.enumeration.Type;
import game.players.interfaces.Positiable;
import game.players.interfaces.Typeable;
import javafx.scene.image.Image;

import java.util.Objects;

public class Person extends Personality implements Positiable, Typeable{
    protected String playerName;
    protected Type type;
    protected Image playerProfile;
    protected int locationX;
    protected int locationY;
    protected int health;
    protected int experience;
    protected int attack;
    protected int defence;
    protected boolean isUser = false;

    public Person(String playerName, Type type, int locationX, int locationY, Image playerProfile) {
        this.setPlayerName(playerName);
        this.setType(type);
        this.setHealth(250);
        this.setExperience(25);
        this.setAttack(100);
        this.setDefence(100);
        this.setLocationX(locationX);
        this.setLocationY(locationY);
        this.setPlayerProfile(playerProfile);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setHealth(int health) {
        if (isUser) {
            this.health += health;
        } else {
            this.health += health / 5;
        }
    }

    public void setExperience(int experience) {
        this.experience = Personality.EXPERIENCE_DEFAULT;
        if (isUser) {
            this.experience += experience;
        }
    }

    public void setAttack(int attack) {
        if (isUser) {
            this.attack += attack;
        } else {
            this.attack += attack / 5;
        }
    }

    public void setDefence(int defence) {
        if (isUser) {
            this.defence += defence;
        } else {
            this.defence += defence / 5;
        }
    }

    @Override
    public void setType(Type type) {
        this.type = type;
        if (Objects.equals(this.type, Type.USER)) {
            this.isUser = true;
        }
    }

    @Override
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    @Override
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    @Override
    public void setPlayerProfile(Image playerProfile) {
        this.playerProfile = playerProfile;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getHealth() {
        return this.health;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public int getLocationX() {
        return this.locationX;
    }

    @Override
    public int getLocationY() {
        return this.locationY;
    }

    public boolean isUser() {
        return this.isUser;
    }
}
