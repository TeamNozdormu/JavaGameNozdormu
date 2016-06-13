package game.players.classes;

import game.players.enumeration.EnemyNames;
import game.players.enumeration.Type;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Random;

public class CreateEnemies {
    private HashMap<String, Enemy> enemies;
    private Image enemy;
    private Canvas enemyCanvas;
    private GraphicsContext graphicsContext;

    public HashMap<String, Enemy> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(HashMap<String, Enemy> enemies) {
        this.enemies = enemies;
    }

    public Image getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Image enemy) {
        this.enemy = enemy;
    }

    public Canvas getEnemyCanvas() {
        return this.enemyCanvas;
    }

    public void setEnemyCanvas(Canvas canvas) {
        this.enemyCanvas = canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public CreateEnemies(int width, int high, Image enemy) {
        this.setEnemies(new HashMap<>());
        this.setEnemy(enemy);
        this.setEnemyCanvas(new Canvas(width, high));
        this.createEnemiesForGame(width, high);
    }

    private void createEnemiesForGame(int width, int high) {
        for (int i = 0; i < 20; i++) {
            EnemyNames name = EnemyNames.values()[i];
            Random randomGenerator = new Random();
            int locationX = randomGenerator.nextInt(width);
            int locationY = randomGenerator.nextInt(high);
            this.getEnemies().put(name + "", new Enemy(name + "", Type.ENEMY, locationX, locationY, this.getEnemy()));
            this.putEnemiesOnMap(locationX, locationY);
        }
    }

    private void putEnemiesOnMap(int locationX, int locationY) {
        this.setGraphicsContext(this.getEnemyCanvas().getGraphicsContext2D());
        this.getGraphicsContext().drawImage(this.getEnemy(), locationX, locationY);
        //TODO sprites cut image - load sprite all
    }
}
