package game;

import game.menu.Menu;
import game.players.classes.Enemy;
import game.players.classes.Person;
import game.players.classes.createEnemies;
import game.players.enumeration.EnemyNames;
import game.players.enumeration.Type;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Random;

public class Main extends Application {

    public static final int WIDTH = 1240;  //800
    public static final int HIGH = 800;    //width / 12 * 9 = 600;
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HIGH = 800;
    public static final String BACKGROUND = "universe.jpg";
    public static final String MAP = "map_Castle.jpg";
    public static final String PLAYER_IMAGE = "player.png";
    public static final String ENEMY_IMAGE = "enemy.png";

    private Menu menu;
    private Group root;
    private Scene rootScene;
    public Scene gameScene;
    private Canvas canvas;
    private Canvas createMap;
    private GraphicsContext graphicsContext;
    private Person player;
    public HashMap<String, Enemy> enemies;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.root = new Group();                                        //create root node
        this.rootScene = new Scene(this.root, WIDTH, HIGH);

        //create map with background
//        this.createMap = new CreateMap(WIDTH, HIGH, new Image(BACKGROUND), new Image(MAP));
//        this.root.getChildren().add(createMap);
        this.canvas = new Canvas(WIDTH, HIGH);
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.graphicsContext.drawImage(new Image(BACKGROUND), 0, 0);    //draw background
        this.graphicsContext.drawImage(new Image(MAP), 0, 0);       //draw map
        this.root.getChildren().add(canvas);

//
//        Canvas canvas2 = new Canvas(1000, 800);
//        GraphicsContext gc2 = canvas2.getGraphicsContext2D();
//        drawShapes(gc2);
//        root.getChildren().add(canvas2);

//        ImageView imageView = new ImageView(ENEMY_IMAGE);
//        imageView.setViewport(new Rectangle2D(0, 0, 65, 65));
//        this.root.getChildren().addAll(canvas, imageView);

        this.menu = new Menu(this.root, this.player);
        this.enemies = new createEnemies(WIDTH, HIGH, new Image(ENEMY_IMAGE)).getEnemies();

        System.out.println();

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");
        primaryStage.setScene(this.rootScene);
        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    i++;
                    Main.this.rootScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent key) {
                            String keyCode = key.getCode().toString();
                            //TODO move steps player
                            System.out.println(key);
                            System.out.println(keyCode);
                        }
                    });
                }
            }
        });

        //move heroes in this timer
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                Main.this.menu.renderGridMenu();
                System.out.println(currentNanoTime);
            }
        }.start();
        gameLoop.start();

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        this.root = null;
        this.rootScene = null;
        this.player = null;
        this.graphicsContext = null;
        this.enemies = null;
        this.canvas = null;
        //release res
    }

    //TODO Move
    private void drawShapes(GraphicsContext shapes) {
        shapes.setStroke(Color.BLUE);
        shapes.strokeRect(85, 95, 690, 615);
        shapes.strokeRect(85, 95, 10, 615);
        shapes.strokeRect(765, 95, 10, 615);
        shapes.strokeRect(85, 95, 690, 10);
        shapes.strokeRect(85, 700, 690, 10);
        //  shapes.strokeOval(95, 105, 105, 105);
        // shapes.strokeOval(660, 105, 105, 105);
        //  shapes.strokeOval(95, 595, 105, 105);
        //  shapes.strokeOval(660, 595, 105, 105);
        shapes.strokeRect(195, 135, 468, 3);
        shapes.strokeRect(197, 154, 465, 3);
        shapes.strokeRect(198, 625, 463, 3);
        shapes.strokeRect(198, 645, 463, 3);
        shapes.strokeRect(720, 208, 15, 392);
        shapes.strokeRect(160, 475, 3, 125);
        shapes.strokeRect(128, 480, 3, 119);
        shapes.strokeRect(95, 475, 40, 3);
        shapes.strokeRect(160, 450, 45, 3);
        shapes.strokeRect(95, 450, 37, 3);
        shapes.strokeRect(160, 475, 45, 3);
        shapes.strokeRect(130, 205,3, 245);
        shapes.strokeRect(160, 205, 3, 245);
        shapes.strokeRect(160, 515,35, 15);
        shapes.strokeRect(225,515,75, 15);
        shapes.strokeRect(325, 515,125,15);
        shapes.strokeRect(370,515, 15, 110 );
        shapes.strokeRect(480, 515, 105, 15);
        shapes.strokeRect(209, 550, 8, 60);
        shapes.strokeRect(235, 550, 8, 60);
        shapes.strokeRect(261, 550, 8, 60);
        shapes.strokeRect(287, 550, 8, 60);
        shapes.strokeRect(327, 570, 15, 35);
        shapes.strokeRect(570, 420, 15, 205);
        shapes.strokeRect(570, 275, 15, 100);
        shapes.strokeRect(570, 190, 15, 55);
        shapes.strokeRect(570, 190, 105, 10);
        shapes.strokeRect(570, 330, 150, 15);
        shapes.strokeRect(670, 210, 30, 40);
        shapes.strokeOval(320, 200, 50, 50);
        shapes.strokeOval(535, 455, 25,25);
        // shapes.strokeArc(95, 105, 105, 105, 18, 236, ArcType.ROUND);
        // shapes.strokeArc(660, 105, 105, 105, 280, 240, ArcType.ROUND);
        shapes.strokeArc(95, 105, 105, 105, 18, 236, ArcType.OPEN);
        shapes.strokeArc(660, 105, 105, 105, 280, 236, ArcType.OPEN);
        shapes.strokeArc(95, 595, 105, 105, 110, 250, ArcType.OPEN);
        shapes.strokeArc(660, 595, 105, 105, 180, 290, ArcType.OPEN);

        shapes.strokeArc(95, 105, 105, 105, 288, 75, ArcType.OPEN);
        shapes.strokeArc(660, 105, 105, 105, 180, 100, ArcType.OPEN);
        shapes.strokeArc(95, 595, 105, 105, 20, 60, ArcType.OPEN);

    }
}
