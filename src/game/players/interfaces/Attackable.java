package game.players.interfaces;

public interface Attackable {
	int getAttack();
	int getExperience();
	void attackPlayer(Dyable player);
}
