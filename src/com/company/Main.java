package com.company;

import com.company.gameobjects.GameImpl;
import com.company.gameobjects.interfaces.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new GameImpl();
        game.start();
    }
}