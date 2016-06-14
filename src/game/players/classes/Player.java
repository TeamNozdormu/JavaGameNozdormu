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
		//TODO formula
		//current health - (attacker attack + attacker experience + attacker defence / 4)
		this.setHealth(currentHealth - attacker.getAttack());
	}

	@Override
	public void defend(Attackable attacker) {
		// TODO formula Auto-generated method stub
		//(defender defence + defender experience + defender attack / 4)
	}

	@Override
	public void attackPlayer(Dyable player) {
		if (player instanceof Defendable) {
			((Defendable) player).defend(this);
		}
		
		player.takeDamage(this);
	}
}
