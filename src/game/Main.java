package game;

import game.menu.Menu;
import game.player.EnemyNames;
import game.player.Player;
import game.player.Type;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Random;

public class Main extends Application {

    public static final int WIDTH = 1240;  //800
    public static final int HIGH = 826;    //width / 12 * 9;
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HIGH = 800;
    public static final String BACKGROUND = "universe.jpg";
    public static final String MAP = "map.png";
    public static final String PLAYER_IMAGE = "player.png";
    public static final String ENEMY_IMAGE = "enemy.png";

    private Menu menu;
    private Group root;
    private Scene rootScene;
    public Scene gameScene;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Player player;
    public HashMap<String, Player> enemies;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.root = new Group();                                        //create root node
        this.rootScene = new Scene(this.root, WIDTH, HIGH);
        //this.gameScene = new Scene(this.root, GAME_WIDTH, GAME_HIGH);
        this.canvas = new Canvas(WIDTH, HIGH);
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.graphicsContext.drawImage(new Image(BACKGROUND), 0, 0);    //draw background
        this.graphicsContext.drawImage(new Image(MAP), 100, 100);       //draw map
        this.root.getChildren().add(canvas);

//        ImageView imageView = new ImageView(ENEMY_IMAGE);
//        imageView.setViewport(new Rectangle2D(0, 0, 65, 65));
//        this.root.getChildren().addAll(canvas, imageView);

        this.menu = new Menu(this.root, this.player);
        this.enemies = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            EnemyNames name = EnemyNames.values()[i];
            Random randomGenerator = new Random();
            int locationX = randomGenerator.nextInt(1100);
            int locationY = randomGenerator.nextInt(1100);
            this.enemies.put(name + "", new Player( name + "", Type.ENEMY, locationX, locationY, new Image(ENEMY_IMAGE)));
        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");
        primaryStage.setScene(this.rootScene);
        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
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
}
