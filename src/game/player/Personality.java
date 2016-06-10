package game.player;

import javafx.scene.image.Image;

public abstract class Personality {
    public static final int HEALTH_DEFAULT = 0;
    public static final int EXPERIENCE_DEFAULT = 0;
    public static final int ATTACK_DEFAULT = 0;
    public static final int DEFENCE_DEFAULT = 0;

    public abstract void setLocationX(int locationX);
    public abstract void setLocationY(int locationY);
    public abstract void setPlayerProfile(Image playerProfile);

    public abstract void setHealth(int health);
    public abstract void setExperience(int experience);
    public abstract void setAttack(int attack);
    public abstract void setDefence(int defence);

    public abstract int getDefence();
    public abstract int getAttack();
    public abstract int getExperience();
    public abstract int getHealth();
}
