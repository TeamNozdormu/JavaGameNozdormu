package game.engine;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.util.Duration;

public class Engine {
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
