package com.company.gamestates;

import com.company.constants.PlayerSettings;
import com.company.eventHandlers.MouseInput;
import com.company.eventHandlers.PlayMusic;
import com.company.gameobjects.base.Bonus;
import com.company.gameobjects.base.Enemy;
import com.company.gameobjects.entities.Bullet;
import com.company.gameobjects.entities.EasyEnemy;
import com.company.gameobjects.entities.Player;
import com.company.gameobjects.entities.SturdyEnemy;
import com.company.graphics.Assets;
import com.company.interfaces.Displayable;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameState extends State implements Displayable {

    public static int score;
    private static Player player;
    private static List<Enemy> enemiesList;
    private static List<Bullet> bulletsList;
    private static List<Bonus> bonusList;
    private static boolean isLevelGained;
    private Random rnd = new Random();
    private long lastTimeMissed, now;
    private int enemyTypes = 1;
    private boolean explode;
    private int cropX, cropY;
    private int cropXMonster = 0, cropYMonster = 0;

    public GameState() {
        if (!this.isLevelGained) {
            this.score = 0;
        } else {
            this.isLevelGained = false;
        }

        init();
        this.bulletsList = new LinkedList<>();
        this.player = new Player(
                PlayerSettings.PLAYER_SET_X,
                PlayerSettings.PLAYER_SET_Y,
                PlayerSettings.PLAYER_DEFAULT_NAME,
                PlayerSettings.PLAYER_DEFAULT_SPEED);

        this.enemiesList = new LinkedList<>();
        this.bonusList = new LinkedList<>();
        enemiesList.add(new EasyEnemy(rnd.nextInt(725), -100));
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

    public static int getScore() {
        return score;
    }

    public static boolean isLevelGained() {
        return isLevelGained;
    }

    public static void setLevelGained(boolean levelGained) {
        isLevelGained = levelGained;
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
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

    private void createSturdyEnemy(int numberOfSturdyEnemies) {
        for (int i = 0; i < numberOfSturdyEnemies; i++) {
            this.getEnemiesList().add(new SturdyEnemy(rnd.nextInt(725), -100));
        }
        this.setEnemyTypes(0);
    }

    @Override
    public void update() {

        if (!explode) {
            player.update();
        }

        //if player misses three enemies loses one live
        if (Enemy.passed >= 3) {
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

        //TODO from here change number of enemies when is level is up
        if (Player.getLevel() == 1) {
            if (this.getEnemiesList().size() < 3) {
                if (this.enemyTypes == 3) {
                    this.createSturdyEnemy(1);
                } else {
                    this.getEnemiesList().add((new EasyEnemy(rnd.nextInt(725), -100)));
                }

                this.setEnemyTypes(this.getEnemyTypes() + 1);
            }
        } else if (Player.getLevel() == 2){
            if (this.getEnemiesList().size() < 5) {
                if (this.enemyTypes == 5) {
                    this.createSturdyEnemy(2);
                } else {
                    this.getEnemiesList().add((new EasyEnemy(rnd.nextInt(725), -100)));
                }

                this.setEnemyTypes(this.getEnemyTypes() + 1);
            }
        } else if (Player.getLevel() == 3) {
            if (this.getEnemiesList().size() < 8) {
                if (this.getEnemyTypes() == 8) {
                    this.createSturdyEnemy(3);
                } else {
                    this.getEnemiesList().add((new EasyEnemy(rnd.nextInt(725), -100)));
                }

                this.setEnemyTypes(this.getEnemyTypes() + 1);
            }
        } else {
            if (this.getEnemiesList().size() < 11) {
                if (this.getEnemyTypes() == 11) {
                    this.createSturdyEnemy(4);
                } else {
                    this.getEnemiesList().add((new EasyEnemy(rnd.nextInt(725), -100)));
                }

                this.setEnemyTypes(this.getEnemyTypes() + 1);
            }
        }

        // Player Ends Playing
        if (player.getNumberOfLives() == 0) {
            if (MouseInput.isMage) {
                PlayMusic.mage.stop();
            } else {
                PlayMusic.archer.stop();
            }
            PlayMusic.fire.stop();

            StateManager.setCurrentState(new GameOverState());
        }

        //player gains level
        if (this.score >= 300 * player.getLevel()) {
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

        g.setFont(new Font("redensek", Font.PLAIN, 40));
        g.setColor(Color.GREEN);
        g.drawString(String.format("Score: %d", this.score), 30, 50);
        g.drawString("Lives: ", 560, 50);

        for (int i = 0; i < player.getNumberOfLives(); i++) {
            g.drawImage(Assets.live, 660 + i * 38, 30, null);
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
}