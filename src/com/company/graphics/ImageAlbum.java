package com.company.graphics;

public enum ImageAlbum {

    //If you add another object to the game you must insert it in the enumeration here in order to get it's path
    RebelPlayer("/Ships/MilleniumFalcon.png"),
    SithPlayer("/Ships/SithInfiltrator.png"),
    EasyEmpireEnemy("/Ships/TIEFighter.png"),
    SturdyEmpireEnemy("/Ships/StarDestroyer.png"),
    EasyRebelsEnemy("/Ships/XWing.png"),
    SturdyRebelsEnemy("/Ships/JediStarFighter.png"),
    DoubleDamageBonus("/InGame/x2Bonus.png"),
    Bullet("/InGame/Bullet.png"),
    Background("/Backgrounds/Battlefield.jpg"),
    Live("/Interface/Live.png"),
    GameOver("/Backgrounds/GameOver.jpg"),
    HighScores("/Backgrounds/HighScores.png"),
    Explosion("/InGame/Explosion.png"),
    ChooseSideBG("/Backgrounds/ChooseSide.jpg"),
    MainMenu("/Backgrounds/MainMenu.jpg"),
    Button("/Interface/Button.png"),
    ButtonSlider("/Interface/ButtonSlider.jpg");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
