package game.players.interfaces;

public interface Defendable extends Dyable{
	int getDefence();
	void defend(Attackable attacker);
}
