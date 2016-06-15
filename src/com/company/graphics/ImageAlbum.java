package com.company.graphics;

public enum ImageAlbum {

    //If you add another object to the game you must insert it in the enumeration here in order to get it's path
    RebelPlayer("/Ships/ArcherIdle.png"),
    SithPlayer("/Ships/ArcherIdle.png"),
    EasyEnemy("/Ships/Monster1Fly.png"),
    SturdyEnemy("/Ships/Monster2Bahamut.png"),
    DoubleDamageBonus("/InGame/x2Bonus.png"),
    Bullet("/InGame/Bullet.png"),
    Background("/Backgrounds/Battlefield.jpg"),
    Live("/Interface/Live.png"),
    GameOver("/Backgrounds/GameOver.jpg"),
    HighScores("/Backgrounds/HighScores.png"),
    Explosion("/InGame/Explosion.png"),
    ChooseSideBG("/Backgrounds/ChoosePlayer.jpg"),
    MainMenu("/Backgrounds/MainMenu.jpg"),
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
