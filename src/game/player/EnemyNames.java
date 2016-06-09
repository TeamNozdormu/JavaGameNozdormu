package game.player;

public enum EnemyNames {
    //TODO enemies name changed after
    Achilles, Ajax, Atlas, Jason,
    Heracles, Odysseus, Calchas, Tiresias,
    Agamemnon, Cephalus, Theseus, Perseus,
    Pelops, Actaeon, Bellerophon, Daedalus,
    Endymion, Ganymede, Orion, Tantalus;

    private int value;

    EnemyNames() {
        this.value = ordinal();
    }
}
