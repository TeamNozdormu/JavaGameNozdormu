package game;

import game.menu.Menu;
import game.menu.StatusMenu;
import game.player.EnemyNames;
import game.player.Player;
import game.player.Type;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {

    private static final int WIDTH = 1240;  //800
    private static final int HIGH = 826;    //width / 12 * 9;
    private static final String BACKGROUND = "universe.jpg";
    private static final String MAP = "map.png";

    private static Menu menu;
    private StatusMenu status;
    private Group root;
    private Scene rootScene;
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
        this.canvas = new Canvas(WIDTH, HIGH);
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.graphicsContext.drawImage(new Image(BACKGROUND), 0, 0);    //draw background
        this.graphicsContext.drawImage(new Image(MAP), 100, 100);       //draw map
        this.root.getChildren().add(canvas);
        this.status = new StatusMenu();
        this.menu = new Menu(this.root, this.status, this.player);
        this.enemies = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            EnemyNames name = EnemyNames.values()[i];
            this.enemies.put(name + "", new Player( name + "", this.status, Type.ENEMY));
        }

        System.out.println("init");
        //init res
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");
        primaryStage.setScene(this.rootScene);
        primaryStage.show();

        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        gameLoop.start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        this.status = null;
        this.root = null;
        this.rootScene = null;
        this.player = null;
        this.graphicsContext = null;
        this.enemies = null;
        this.canvas = null;
        //release res
    }
}
