package com.company.screenStates;

import com.company.eventHandlers.PlayMusic;
import com.company.game.AbstractObjects.Bonus;
import com.company.game.AbstractObjects.Enemy;
import com.company.game.concreteObjects.Bullet;
import com.company.game.concreteObjects.EasyEnemy;
import com.company.game.concreteObjects.Player;
import com.company.game.concreteObjects.SturdyEnemy;
import com.company.gameObjectsInterfaces.Displayable;
import com.company.graphics.Assets;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameState extends State implements Displayable {

    public static Player player;
    public static List<Enemy> enemiesList;
    public static List<Bullet> bulletsList;
    public static List<Bonus> bonusList;
    public static int score;
    public Random rnd = new Random();
    private long lastTimeMissed, now;
    private int enemyTypes = 1;
    private boolean explode;
    private int cropX, cropY;
    private int cropXMonster = 0, cropYMonster = 0;

    public GameState() {
        score = 0;
        init();
        this.bulletsList = new LinkedList<>();
        this.player = new Player(350, 500, "Player", 15);
        this.enemiesList = new LinkedList<>();
        this.bonusList = new LinkedList<>();
        enemiesList.add(new EasyEnemy(rnd.nextInt(725), -100));
    }

    public void init() {
        Assets.init();
    }


    @Override
    public void update() {

        if (!this.explode) {
            player.update();
        }

        //if player misses three enemies loses one live
        if (Enemy.passed >= 3) {
            player.setNumberOfLives(player.getNumberOfLives() - 1);
            this.lastTimeMissed = System.currentTimeMillis();
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
                PlayMusic.death.play();
                enemiesList.get(i).setColliderBox(new Rectangle(0, 0, 1, 1));
                break;
            }

            if (!this.explode) {
                enemiesList.get(i).update();
            }
        }

        if (enemiesList.size() < 3) {
            if (enemyTypes == 3) {
                enemiesList.add(new SturdyEnemy(rnd.nextInt(725), -100));
                enemyTypes = 0;
            } else {
                enemiesList.add((new EasyEnemy(rnd.nextInt(725), -100)));
            }

            enemyTypes++;
        }

        // Player Ends Playing
        if (player.getNumberOfLives() == 0) {
            PlayMusic.music.stop();
            StateManager.setCurrentState(new GameOverState());
        }

        if (this.explode) {
            cropX++;
            if (cropX >= 6) {
                //cropY++;
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
        g.drawImage(Assets.background, 0, 0, null);

        if (player.getCurrentBonus() != null) {
            g.drawImage(player.getCurrentBonus().getObjectIcon(), 730, 530, null);
        }

        if (!this.explode) {
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
                g.drawImage(Assets.easyEnemy.crop(cropXMonster, cropYMonster), enemiesList.get(i).getX() - 20, enemiesList.get(i).getY(), null);
            } else {
                g.drawImage(Assets.sturdyEnemy.crop(cropXMonster, cropYMonster), enemiesList.get(i).getX() - 20, enemiesList.get(i).getY(), null);
            }

            cropXMonster += 1;
            if (cropXMonster >= 4) {
                cropXMonster = 0;
            }

        }

        g.setFont(new Font("Immortal", Font.PLAIN, 40));
        g.setColor(Color.white);
        g.drawString(String.format("Score: %d", this.score), 30, 50);
        g.drawString("Lives: ", 540, 50);

        for (int i = 0; i < player.getNumberOfLives(); i++) {
            g.drawImage(Assets.live, 660 + i * 38, 30, null);
        }

        now = System.currentTimeMillis();

        if (now - lastTimeMissed < 3000) {
            g.setFont(new Font("Immortal", Font.CENTER_BASELINE, 45));
            g.drawString("You've missed three enemies!", 50, 200);
        }

        if (explode) {
            // g.drawImage(Assets.explosion.crop(cropX, cropY), player.getX() - 20, player.getY(), null);
            g.drawImage(Assets.die.crop(cropX, cropY), player.getX(), player.getY(), null);

        }

    }

}
