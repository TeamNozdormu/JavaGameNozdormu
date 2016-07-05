package com.company;

import com.company.gameobjects.Game;

public class Main {
    public static void main(String[] args) {
        //  State state = new MainMenuState();
        // TODO: Load from file - ?
        Game game = new Game();
        game.start();
    }
}