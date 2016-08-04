package com.company.gamestates;

import com.company.constants.GameSettings;
import com.company.constants.PlayerSettings;
import com.company.eventHandlers.MouseInput;
import com.company.eventHandlers.PlayMusic;
import com.company.gameobjects.base.Bonus;
import com.company.gameobjects.base.Enemy;
import com.company.gameobjects.entities.Bullet;
import com.company.gameobjects.entities.EasyEnemy;
import com.company.gameobjects.entities.Player;
import com.company.gameobjects.factory.Factory;
import com.company.graphics.utililies.Assets;
import com.company.helperClasses.RandomGenerator;
import com.company.interfaces.Displayable;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameState extends State implements Displayable {

    private static final int LEVEL_POINTS = 300;
    private static final int MISSED_ENEMIES = 3;
    public static int score;
    private static Player player;
    private static List<Enemy> enemiesList;
    private static List<Bullet> bulletsList;
    private static List<Bonus> bonusList;
    private static Factory factory;
    private static boolean isLevelGained;
    private long lastTimeMissed, now;
    private int enemyTypes = 1;
    private boolean explode;
    private int cropX, cropY;
    private int cropXMonster = 0, cropYMonster = 0;

    public GameState() {
        if (!isLevelGained) {
            this.score = 0;
        } else {
            isLevelGained = false;
        }

        init();
        factory = new Factory();
        bulletsList = new LinkedList<>();
        player = new Player(PlayerSettings.PLAYER_SET_X, PlayerSettings.PLAYER_SET_Y, PlayerSettings
                .PLAYER_DEFAULT_NAME, PlayerSettings.PLAYER_DEFAULT_SPEED);
        enemiesList = new LinkedList<>();
        bonusList = new LinkedList<>();
        enemiesList.add(new EasyEnemy(RandomGenerator.getNextIntRandom(725), -100, 1, 2));
    }

    public static Player getPlayer() {
        return player;
    }

    public static List<Enemy> getEnemiesList() {
        return enemiesList;
    }

    public static List<Bullet> getBulletsList() {
        return bulletsList;
    }

    public static List<Bonus> getBonusList() {
        return bonusList;
    }

    private static Factory getFactory() {
        return factory;
    }

    public static int getScore() {
        return score;
    }

    public static boolean isLevelGained() {
        return isLevelGained;
    }

    public static void setLevelGained(boolean levelGained) {
        isLevelGained = levelGained;
    }

    public long getLastTimeMissed() {
        return lastTimeMissed;
    }

    public void setLastTimeMissed(long lastTimeMissed) {
        this.lastTimeMissed = lastTimeMissed;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public int getEnemyTypes() {
        return enemyTypes;
    }

    public void setEnemyTypes(int enemyTypes) {
        this.enemyTypes = enemyTypes;
    }

    public boolean isExplode() {
        return explode;
    }

    public void setExplode(boolean explode) {
        this.explode = explode;
    }

    public int getCropX() {
        return cropX;
    }

    public void setCropX(int cropX) {
        this.cropX = cropX;
    }

    public int getCropY() {
        return cropY;
    }

    public void setCropY(int cropY) {
        this.cropY = cropY;
    }

    public int getCropXMonster() {
        return cropXMonster;
    }

    public void setCropXMonster(int cropXMonster) {
        this.cropXMonster = cropXMonster;
    }

    public int getCropYMonster() {
        return cropYMonster;
    }

    public void setCropYMonster(int cropYMonster) {
        this.cropYMonster = cropYMonster;
    }

    public void init() {
        Assets.init();
    }

    @Override
    public void update() {

        if (!explode) {
            player.update();
        }

        //if player misses three enemies loses one live
        if (Enemy.passed >= MISSED_ENEMIES) {
            player.setNumberOfLives(player.getNumberOfLives() - 1);
            lastTimeMissed = System.currentTimeMillis();
            Enemy.passed = 0;
            enemiesList.clear();
        }

        for (int i = 0; i < bulletsList.size(); i++) {
            bulletsList.get(i).update();
        }

        for (int i = 0; i < bonusList.size(); i++) {
            bonusList.get(i).update();
        }

        for (int i = 0; i < enemiesList.size(); i++) {

            if (player.collide(enemiesList.get(i).getColliderBox())) {
                player.setNumberOfLives(player.getNumberOfLives() - 1);
                explode = true;
                PlayMusic.boom.play();
                enemiesList.get(i).setColliderBox(new Rectangle(0, 0, 1, 1));

                break;
            }

            if (!explode) {
                enemiesList.get(i).update();
            }
        }

        //player gains level
        this.increaseLevel();

        // Player Ends Playing
        this.gameOver();

        if (explode) {
            cropX++;
            if (cropX >= 6) {
                cropX = 0;
                explode = false;
                enemiesList.clear();
                player.setX(350);
                player.setY(500);
            }
        }

        //change difficulty
        if (getEnemiesList().size() < Player.getLevel() * 3) {
            if (this.getEnemyTypes() == Player.getLevel() * 3) {
                this.createSturdyEnemies(Player.getLevel());
            } else {
                this.addNewEasyEnemy();
            }

            this.setEnemyTypes(this.getEnemyTypes() + 1);
        }
    }

    @Override
    public void display(Graphics g) {
//        very slow

//        GameMap map = new GameMap(
//                GameSettings.GAME_WIDTH,
//                GameSettings.GAME_HEIGHT);
//
//        for (Field field : map.getFields()) {
//            g.drawImage(field.getPicture(), field.getX(), field.getY(), null);
//        }


        //TODO draw map
        g.drawImage(Assets.background, 0, 0, null);


        if (player.getCurrentBonus() != null) {
            g.drawImage(player.getCurrentBonus().getObjectIcon(), 730, 530, null);
        }

        if (!explode) {
            player.display(g);
        }

        for (int i = 0; i < bonusList.size(); i++) {
            bonusList.get(i).display(g);
        }

        for (int i = 0; i < bulletsList.size(); i++) {
            bulletsList.get(i).display(g);
        }

        for (int i = 0; i < enemiesList.size(); i++) {
            // enemiesList.get(i).display(g);
            if (enemiesList.get(i).getPointsForPlayer() == 5) {
                g.drawImage(Assets.easyEnemy.crop(cropXMonster, cropYMonster), enemiesList.get(i).getX() - 20,
                        enemiesList.get(i).getY(), null);
            } else {
                g.drawImage(Assets.sturdyEnemy.crop(cropXMonster, cropYMonster), enemiesList.get(i).getX() - 20,
                        enemiesList.get(i).getY(), null);
            }

            cropXMonster += 1;
            if (cropXMonster >= 4) {
                cropXMonster = 0;
            }

        }

        g.setFont(new Font("redensek", Font.PLAIN, 25));
        g.setColor(Color.RED);
        g.drawString(String.format("Level: %d", player.getLevel()), 560, 50);
        g.drawString(String.format("Next Level: %d", player.getNextLevel()), 560, 80);
        g.drawString(String.format("Score: %d", this.score), 560, 110);
        g.drawString("Lives: ", 560, 140);
        g.drawString(String.format("Monsters: %d", getEnemiesList().size()), 560, 170);
        g.drawString(String.format("Monster to kill: %d", (MISSED_ENEMIES - Enemy.passed)), 500, 200);

        for (int i = 0; i < player.getNumberOfLives(); i++) {
            g.drawImage(Assets.live, 660 + i * 35, 1, null);
        }

        now = System.currentTimeMillis();

        if (now - lastTimeMissed < 3000) {
            g.setFont(new Font("redensek", Font.CENTER_BASELINE, 50));
            g.drawString("You've missed three enemies", 50, 200);
        }

        if (explode) {
            g.drawImage(Assets.die.crop(cropX, cropY), player.getX(), player.getY(), null);
        }
    }

    private void createSturdyEnemies(int numberOfSturdyEnemies) {
        for (int i = 0; i < numberOfSturdyEnemies; i++) {
            int health = RandomGenerator.getNextIntRandom(4);
            getEnemiesList()
                    .add(getFactory()
                            .createSturdyEnemy(
                                    RandomGenerator.getNextIntRandom(GameSettings.GAME_WIDTH - 100),
                                    -100,
                                    health > 0 ? health : 1,
                                    RandomGenerator.getNextIntRandom(Player.getLevel() + 1)));
        }
        this.setEnemyTypes(0);
    }

    private void addNewEasyEnemy() {
        getEnemiesList()
                .add(getFactory()
                        .createEasyEnemy(
                                RandomGenerator.getNextIntRandom(GameSettings.GAME_WIDTH - 100),
                                -100,
                                1,
                                2));
    }

    private void gameOver() {
        if (player.getNumberOfLives() == 0) {
            if (MouseInput.isMage) {
                PlayMusic.mage.stop();
            } else {
                PlayMusic.archer.stop();
            }
            PlayMusic.fire.stop();
            player.setLevel(1);
            StateManager.setCurrentState(new GameOverState());
        }
    }

    private void increaseLevel() {
        if (this.score >= player.getNextLevel()) {
            player.setNextLevel(
                    LEVEL_POINTS * player.getLevel() +
                            (RandomGenerator.getNextIntRandom(LEVEL_POINTS * player.getLevel()) * 2 / 3));
            if (MouseInput.isMage) {
                PlayMusic.mage.stop();
            } else {
                PlayMusic.archer.stop();
            }

            PlayMusic.fire.stop();

            Player.inceraseLevel();
            this.isLevelGained = true;

            StateManager.setCurrentState(new GainLevelState());
        }
    }
}