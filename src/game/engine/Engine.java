package game.engine;

import game.contracts.Updatable;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.awt.*;

public class Engine implements Updatable{
    private int frameCount = 0;
    private int frameRate;
    private final Game game;
    private final Timeline gameLoop;

    public Engine(int frameRate, Game game) {
        this.frameRate = frameRate;
        this.game = game;
        game.setEngine(this);
        gameLoop = createLoop();
    }

    public int getFrameCount() {
        return frameCount;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    private void run(Event e) {
        frameCount++;
        game.update();
        game.display();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(GraphicsContext gc) {

    }

    public void start() {
        gameLoop.playFromStart();
    }

    public void stop() {
        gameLoop.stop();
    }

    private Timeline createLoop() {
        final Duration d = Duration.millis(1000 / frameRate);
        final KeyFrame oneFrame = new KeyFrame(d, this::run);
        Timeline t = new Timeline(frameRate, oneFrame);
        t.setCycleCount(Animation.INDEFINITE);
        return t;
    }
}
