package game.players.classes;

import game.Main;
import game.players.enumeration.Type;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CreatePlayer {
    private Person player;
    private Image playerImage;
    private Canvas playerCanvas;
    private GraphicsContext graphicsContext;

    public Person getPlayer() {
        return this.player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Image getPlayerImage() {
        return this.playerImage;
    }

    public void setPlayerImage(Image player) {
        this.playerImage = player;
    }

    public Canvas getPlayerCanvas() {
        return this.playerCanvas;
    }

    public void setPlayerCanvas(Canvas playerCanvas) {
        this.playerCanvas = playerCanvas;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public CreatePlayer(String username, Image player) {
        this.setPlayerCanvas(new Canvas(Main.GAME_WIDTH, Main.GAME_HIGH));
        this.setPlayerImage(player);
        this.setPlayer(new Player(username, Type.USER, 100, 100, this.getPlayerImage()));
        this.putPlayerOnMap(100, 100);
    }

    public void putPlayerOnMap(int locationX, int locationY) {
        this.setGraphicsContext(this.getPlayerCanvas().getGraphicsContext2D());
        this.getGraphicsContext().drawImage(this.getPlayerImage(), locationX, locationY);
    }
}
