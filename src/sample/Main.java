package sample;

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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");

        Group root = new Group();
        Scene theScene = new Scene(root, width, high);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(width, high);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image background = new Image("test.jpg", true);
        gc.drawImage(background, width, high);

        primaryStage.show();
    }
}
