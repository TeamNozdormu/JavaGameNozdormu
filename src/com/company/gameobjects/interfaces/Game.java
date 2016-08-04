package com.company.gameobjects.interfaces;

import com.company.gamestates.interfaces.State;
import com.company.graphics.Display;
import com.company.graphics.GameMap;

import java.awt.*;

/**
 * Created by Eli on 8/4/2016.
 */
public interface Game {
    GameMap getMap();

    Display getDisplay();

    Graphics getGraphics();

    State getGameState();

    void displayFrame();

    void start();

    void stop();
}
