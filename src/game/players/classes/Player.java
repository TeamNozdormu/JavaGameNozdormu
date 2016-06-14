package game.players.classes;

import game.players.enumeration.Type;
import game.players.interfaces.*;
import javafx.scene.image.Image;

public class Player extends Person implements Attackable, Defendable, Dyable{
    public Player(String playerName, Type type, int locationX, int locationY, Image playerProfile) {
        super(playerName, type, locationX, locationY, playerProfile);
    }

	@Override
	public void takeDamage(Attackable attacker) {
		int currentHealth = this.getHealth();
		this.setHealth(currentHealth - attacker.getAttack());
	}

	@Override
	public void defend(Attackable attacker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackPlayer(Dyable player) {
		if (player instanceof Defendable) {
			((Defendable) player).defend(this);
		}
		
		player.takeDamage(this);
	}
}
