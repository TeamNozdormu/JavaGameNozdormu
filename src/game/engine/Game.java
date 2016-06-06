package game.engine;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class Game {
    GraphicsContext gc;
    Engine engine;

    public final int MAX_WIDTH;
    public final int MAX_HIGH;

    public Game(int w, int h) {
        MAX_WIDTH = w;
        MAX_HIGH = h;
        Canvas canvas = new Canvas(MAX_WIDTH, MAX_HIGH);
        gc = canvas.getGraphicsContext2D();
    }

    final public void setEngine(Engine _engine) {
        engine = _engine;
    }

    public abstract void update();

    public abstract void display();
}
