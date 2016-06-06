package game;

import game.menu.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int width = 1240;  //800
    private static final int high = 826;    //width / 12 * 9;
    private static Menu menu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        //init res
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");

        Group root = new Group();
        Scene theScene = new Scene(root, width, high);
        Canvas canvas = new Canvas(width, high);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image background = new Image("universe.jpg");
        Image map = new Image("map.png");

        gc.drawImage(background, 0, 0);
        gc.drawImage(map, 100, 100);

        root.getChildren().add(canvas);
        menu = new Menu(root);

        primaryStage.setScene(theScene);
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
        //release res
    }
}
