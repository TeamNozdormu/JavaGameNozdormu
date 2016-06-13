package game.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.security.acl.Group;

public class CreateMap extends Canvas{
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Image background;
    private Image map;

    public Image getMap() {
        return this.map;
    }

    public void setMap(Image map) {
        this.map = map;
    }

    public Image getBackground() {
        return this.background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public CreateMap(int with, int high, Image background, Image map) {
        this.setCanvas(new Canvas(with, high));
        this.setBackground(background);
        this.setMap(map);
        this.setGraphicsContext(this.getCanvas().getGraphicsContext2D());
        this.createMap();
        //TODO not create map - return 0 with why
    }

    private void createMap() {
        this.getGraphicsContext().drawImage(this.getBackground(), 0, 0);
        this.getGraphicsContext().drawImage(this.getMap(), 0, 0);
    }
}
