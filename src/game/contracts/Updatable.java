package game.contracts;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public interface Updatable {

    public abstract void tick();
    public abstract void render(GraphicsContext gc);

}
