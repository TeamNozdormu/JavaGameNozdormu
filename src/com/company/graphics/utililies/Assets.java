package com.company.graphics.utililies;

import com.company.eventhandlers.utilities.MouseInput;
import com.company.graphics.ImageLoader;
import com.company.graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

public final class Assets {

    public static BufferedImage backgroundDifficulty;
    public static BufferedImage background;
    public static BufferedImage player;
    public static BufferedImage bullet;
    public static BufferedImage easyEnemyInit;
    public static BufferedImage sturdyEnemyInit;
    public static BufferedImage doubleDamageBonus;
    public static BufferedImage highScoresBackground;
    public static BufferedImage live;
    public static BufferedImage gameover;
    public static BufferedImage intro;
    public static BufferedImage introTask;
    public static BufferedImage chooseSide;
    public static BufferedImage gainLevel;
    public static BufferedImage mainMenuBackground;
    public static BufferedImage button;
    public static BufferedImage buttonBar;
    public static BufferedImage[] sprites = new BufferedImage[4];
    public static SpriteSheet die;
    public static SpriteSheet easyEnemy;
    public static SpriteSheet sturdyEnemy;

    public static Map<String, Integer> highScores;
    public static int lowestScore;

    private static SortedMap<String, Integer> scores;

    public static void init() {
        background = ImageLoader.loadImage(ImageAlbum.Background.getPath());

        //  if(MouseInput.isEasyBotton) {
        if (MouseInput.isMage) {
            player = (ImageLoader.loadImage(ImageAlbum.MagePlayer.getPath()));
            bullet = ImageLoader.loadImage(ImageAlbum.FireBall.getPath());
            die = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.MageDeath.getPath()), 64, 64);
        } else {
            player = ImageLoader.loadImage(ImageAlbum.ArcherPlayer.getPath());
            bullet = ImageLoader.loadImage(ImageAlbum.Arrow.getPath());
            die = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.ArcherDeath.getPath()), 66, 59);
        }

        easyEnemy = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.EasyEnemy.getPath()), 97, 56);
        easyEnemyInit = easyEnemy.crop(1, 0);
        sturdyEnemy = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.SturdyEnemy.getPath()), 95, 98);
        sturdyEnemyInit = sturdyEnemy.crop(1, 0);
        live = ImageLoader.loadImage(ImageAlbum.Live.getPath());
        doubleDamageBonus = ImageLoader.loadImage(ImageAlbum.DoubleDamageBonus.getPath());
        highScoresBackground = ImageLoader.loadImage(ImageAlbum.HighScores.getPath());
        gameover = ImageLoader.loadImage(ImageAlbum.GameOver.getPath());
        intro = ImageLoader.loadImage(ImageAlbum.Intro.getPath());
        introTask = ImageLoader.loadImage(ImageAlbum.IntroTask.getPath());
        gainLevel = ImageLoader.loadImage(ImageAlbum.LevelGained.getPath());
        chooseSide = ImageLoader.loadImage(ImageAlbum.ChooseClass.getPath());
        backgroundDifficulty = ImageLoader.loadImage(ImageAlbum.BackgroundDifficulty.getPath());
        mainMenuBackground = ImageLoader.loadImage(ImageAlbum.MainMenu.getPath());
        button = ImageLoader.loadImage(ImageAlbum.Button.getPath());
        buttonBar = ImageLoader.loadImage(ImageAlbum.ButtonSlider.getPath());

        //Loading font
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //TODO change font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res\\REDENSEK.TTF")));
        } catch (IOException | FontFormatException e) {
            //TODO Handle exception
        }
    }

    public static void loadingHighScores(String order) {
        scores = new TreeMap<>();
        highScores = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list;

        try (BufferedReader fileReader = new BufferedReader(new FileReader("res\\highScores.txt"))) {
            String line = fileReader.readLine();
            String[] tokens;

            while (line != null) {
                tokens = line.split("\\s+");
                scores.put(tokens[0], Integer.parseInt(tokens[1]));
                line = fileReader.readLine();
            }
        } catch (IOException ioex) {
            System.err.println("Cannot read the file");
        }

        list = new ArrayList<>(scores.entrySet());

        if (order.equalsIgnoreCase("ascending")) {
            Collections.sort(list, (a, b) -> a.getValue().compareTo(b.getValue()));
        } else {
            Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        }

        if (list.size() > 10) {
            list.subList(0, 10);
        }

        for (Map.Entry<String, Integer> entry : list) {
            highScores.put(entry.getKey(), entry.getValue());
        }

        if (list.size() > 0) {
            lowestScore = list.get(list.size() - 1).getValue();
        }
    }

    public static void savingHighScores(String name, int score) {
        if (score > lowestScore || highScores.size() < 10) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("res\\highScores.txt", true))) {
                writer.println(name + " " + score);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
