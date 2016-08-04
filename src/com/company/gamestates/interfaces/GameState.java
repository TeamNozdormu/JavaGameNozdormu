package com.company.gamestates.interfaces;

public interface GameState {

    long getLastTimeMissed();

    long getNow();

    int getEnemyTypes();

    public boolean isExplode();

    int getCropX();

    int getCropY();

    int getCropXMonster();

    int getCropYMonster();

}
