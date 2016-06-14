package game.state;

import game.contracts.Updatable;
import game.engine.Engine;

public abstract class State implements Updatable {
    protected Engine game;

    public State(Engine game){
        this.game = game;
    }
}
