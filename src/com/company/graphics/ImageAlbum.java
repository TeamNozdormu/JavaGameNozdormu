package com.company.graphics;

public enum ImageAlbum {

    //If you add another object to the game you must insert it in the enumeration here in order to get it's path
    ArcherPlayer("/Characters/ArcherIdle.png"),
    MagePlayer("/Characters/MageIdle.png"),
    EasyEnemy("/Characters/Monster1Fly.png"),
    SturdyEnemy("/Characters/Monster2Bahamut.png"),
    DoubleDamageBonus("/InGame/x2Bonus.png"),
    Bullet("/InGame/Arrow.png"),
    Background("/Backgrounds/GrassField.png"),
    Live("/Interface/Life.png"),
    GameOver("/Backgrounds/Background.jpg"),
    HighScores("/Backgrounds/Background.jpg"),
    Explosion("/InGame/ArcherDeath.png"),
    ArcherDeath("/InGame/ArcherDeath.png"),
    MageDeath("/InGame/MageDeath.png"),
    ChooseClass("/Backgrounds/ChooseClass.jpg"),
    MainMenu("/Backgrounds/Background.jpg"),
    Button("/Interface/ButtonGreen.png"),
    ButtonSlider("/Interface/IvySlider.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
