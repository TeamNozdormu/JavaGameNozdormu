package com.company.graphics;

public enum ImageAlbum {

    //If you add another object to the gameobjects you must insert it in the enumeration here in order to get it's path
    BackgroundDifficulty("/Backgrounds/DifficultyBackground.png"),
    ArcherPlayer("/Characters/ArcherIdle.png"),
    ArcherPlayerL("/Characters/ArcherIdleLeft.png"),
    ArcherPlayerR("/Characters/ArcherIdleRight.png"),
    MagePlayer("/Characters/MageIdle.png"),
    EasyEnemy("/Characters/Bat.png"),
    SturdyEnemy("/Characters/Bahamut.png"),
    DoubleDamageBonus("/InGame/x2Bonus.png"),
    Arrow("/InGame/Arrow.png"),
    FireBall("/InGame/FireBall.gif"),
    //  Background("/Backgrounds/OrtogonalMap.png"),
    Background("/Backgrounds/Background1.png"),
    Live("/Interface/Life.png"),
    GameOver("/Backgrounds/Background.jpg"),
    Intro("/Backgrounds/Intro.png"),
    IntroTask("/Backgrounds/YseraIntro.png"),
    LevelGained("/Backgrounds/LevelGained.png"),
    HighScores("/Backgrounds/Background.jpg"),
    Explosion("/InGame/ArcherDeath.png"),
    ArcherDeath("/InGame/ArcherDeath.png"),
    MageDeath("/InGame/MageDeath.png"),
    ChooseClass("/Backgrounds/ChooseClass.jpg"),
    MainMenu("/Backgrounds/Background.jpg"),
    Button("/Interface/ButtonGreen.png"),
    ButtonSlider("/Interface/IvySlider.png"),
    Field("/Backgrounds/Field.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
