package game.menu;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class Menu {
    private Button start;
    private Button player;

    public Menu(Group group) {
        this.createButtons();
        group.getChildren().add(start);
        group.getChildren().add(player);
    }

    private void createButtons() {
        this.start = new Button();
        this.player = new Button();

        start.setText("Start Game");
        start.setLayoutX(930);
        start.setLayoutY(50);

        player.setText("Create Player");
        player.setLayoutX(800);
        player.setLayoutY(50);
    }
}
