package com.company.gamestates.utilities;

import com.company.gamestates.interfaces.State;

public final class StateManager {

    private static State currentState;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State newState) {
        currentState = newState;
    }
}

