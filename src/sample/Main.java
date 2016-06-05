package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int width = 800;
    private static final int high = width / 12 * 9;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game Nozdormu");
        Group root = new Group();
        Scene theScene = new Scene(root, width, high);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(250, 250);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image background = new Image("imgpsh_fullsize.png");
        gc.drawImage(background, width, high);



        primaryStage.show();
    }
}
