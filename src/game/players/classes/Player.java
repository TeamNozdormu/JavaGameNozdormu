package game.players.classes;

import game.players.enumeration.Type;
import javafx.scene.image.Image;

public class Player extends Person {
    public Player(String playerName, Type type, int locationX, int locationY, Image playerProfile) {
        super(playerName, type, locationX, locationY, playerProfile);
    }
}
