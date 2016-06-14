package game.state;

public class StateManager {
    private static State currentState = null;
    private State mainState;
    private State endGameState;



    public static State getCurrentState(){
        return currentState;
    }

    public static void setCurrentState(State state){
        currentState = state;
    }
}
