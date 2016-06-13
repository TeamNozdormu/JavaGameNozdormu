package game.players.classes;

import game.players.enumeration.Type;
import javafx.scene.image.Image;

public class Enemy extends Person {
    public Enemy(String playerName, Type type, int locationX, int locationY, Image playerProfile) {
        super(playerName, type, locationX, locationY, playerProfile);
    }
}