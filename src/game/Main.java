package game;

import game.Map.CreateMap;
import game.menu.Menu;
import game.players.classes.CreatePlayer;
import game.players.classes.Enemy;
import game.players.classes.CreateEnemies;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {

    public static final int WIDTH = 1240;  //800
    public static final int HIGH = 800;    //width / 12 * 9 = 600;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HIGH = 608;
    public static final String BACKGROUND = "universe.jpg";
    public static final String MAP = "map-normal.png";
    public static final String PLAYER_IMAGE = "playerView.png";
    public static final String ENEMY_IMAGE = "enemyMonster.png";

    private Menu menu;
    private Group root;
    private Scene rootScene;
    public Scene gameScene;
    private CreateMap createMap;
    private CreatePlayer player;
    private boolean createdPlayer;
    public HashMap<String, Enemy> enemies;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.root = new Group();                                        //create root node
        this.rootScene = new Scene(this.root, WIDTH, HIGH);

        //create map with backgroundImage
        this.createMap = new CreateMap(WIDTH, HIGH, new Image(BACKGROUND), new Image(MAP));
        this.root.getChildren().add(this.createMap.getCanvas());

        CreateEnemies createdEnemies = new CreateEnemies(GAME_WIDTH, GAME_HIGH, new Image(ENEMY_IMAGE));
        this.enemies = createdEnemies.getEnemies();
        this.root.getChildren().add(createdEnemies.getEnemyCanvas());
//
//        Canvas canvas2 = new Canvas(800, 800);
//        GraphicsContext gc2 = canvas2.getGraphicsContext2D();
//        drawShapes(gc2);
//        root.getChildren().add(canvas2);

//        ImageView imageView = new ImageView(ENEMY_IMAGE);
//        imageView.setViewport(new Rectangle2D(0, 0, 65, 65));
//        this.root.getChildren().addAll(canvas, imageView);

        this.menu = new Menu(this.root, this.player);
        this.createdPlayer = false;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");
        primaryStage.setScene(this.rootScene);

        //move hero in this timer
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                Main.this.menu.renderGridMenu();
                Main.this.player = Main.this.menu.getPlayerGame();
                if (Main.this.player != null && !Main.this.createdPlayer) {
                    Main.this.createdPlayer = true;
                    //put created player on map
                    Main.this.root.getChildren().add(Main.this.player.getPlayerCanvas());
                }

                Main.this.rootScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent key) {
                        String keyCode = key.getCode().toString();
                        //TODO move steps player

                        if (Main.this.createdPlayer) {

                           //Main.this.player.move(keyCode);

                        }

                        System.out.println(key);
                        System.out.println(keyCode);
                    }
                });

                System.out.println(currentNanoTime);
            }
        }.start();

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        this.root = null;
        this.rootScene = null;
        this.gameScene = null;
        this.createMap = null;
        this.player = null;
        this.enemies = null;
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
