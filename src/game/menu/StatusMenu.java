package game.menu;

public class StatusMenu {
    private static final int HEALTH_DEFAULT = 0;
    private static final int EXPERIENCE_DEFAULT = 0;
    private static final int ATTACK_DEFAULT = 0;
    private static final int DEFENCE_DEFAULT = 0;

    private int Health;
    private int Experience;
    private int Attack;
    private int Defence;

    public StatusMenu() {
        this.setAttack(ATTACK_DEFAULT);
        this.setDefence(DEFENCE_DEFAULT);
        this.setExperience(EXPERIENCE_DEFAULT);
        this.setHealth(HEALTH_DEFAULT);
    }

    public void setHealth(int health) {
        this.Health = health;
        //TODO Validation
    }

    public void setExperience(int experience) {
        this.Experience = experience;
        //TODO Validation
    }

    public void setAttack(int attack) {
        this.Attack = attack;
        //TODO Validation
    }

    public void setDefence(int defence) {
        this.Defence = defence;
        //TODO Validation
    }

    public int getDefence() {
        return this.Defence;
    }

    public int getAttack() {
        return this.Attack;
    }

    public int getExperience() {
        return this.Experience;
    }

    public int getHealth() {
        return this.Health;
    }

}
