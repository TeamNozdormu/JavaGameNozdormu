package com.company.screenStates;

public class StateManager {

    private static State currentState;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State newState) {
        currentState = newState;
    }

}

