package game.menu;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Menu {
    private Button start;
    private Button player;
    private GridPane gridMenu;

    public Menu(Group group, StatusMenu status) {
        this.createGrid(status);
        this.createButtons();
        group.getChildren().add(start);
        group.getChildren().add(player);
        group.getChildren().add(this.gridMenu);
    }

    private void  createGrid(StatusMenu status) {
        this.gridMenu = new GridPane();
        this.gridMenu.setPadding(new Insets(5));
        this.gridMenu.setHgap(5);
        this.gridMenu.setVgap(5);
        ColumnConstraints columnOne = new ColumnConstraints(100);
        ColumnConstraints columnTwo = new ColumnConstraints(50, 100, 200);
        this.gridMenu.getColumnConstraints().addAll(columnOne, columnTwo);

        Label health = new Label("Health:");
        health.setTextFill(Color.web("#FFFFFF"));
        Label healthValue = new Label(status.getHealth() + "");
        healthValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(health, HPos.LEFT);
        GridPane.setHalignment(healthValue, HPos.RIGHT);
        this.gridMenu.add(health, 0, 0);
        this.gridMenu.add(healthValue, 1, 0);

        Label attack = new Label("Attack:");
        attack.setTextFill(Color.web("#FFFFFF"));
        Label attackValue = new Label(status.getAttack() + "");
        attackValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(attack, HPos.LEFT);
        GridPane.setHalignment(attackValue, HPos.RIGHT);
        this.gridMenu.add(attack, 0, 1);
        this.gridMenu.add(attackValue, 1, 1);

        Label defence = new Label("Defence:");
        defence.setTextFill(Color.web("#FFFFFF"));
        Label defenceValue = new Label(status.getDefence() + "");
        defenceValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(defence, HPos.LEFT);
        GridPane.setHalignment(defenceValue, HPos.RIGHT);
        this.gridMenu.add(defence, 0, 2);
        this.gridMenu.add(defenceValue, 1, 2);

        Label experience = new Label("Experience:");
        experience.setTextFill(Color.web("#FFFFFF"));
        Label experienceValue = new Label(status.getExperience() + "");
        experienceValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(experience, HPos.LEFT);
        GridPane.setHalignment(experienceValue, HPos.RIGHT);
        this.gridMenu.add(experience, 0, 3);
        this.gridMenu.add(experienceValue, 1, 3);
        this.gridMenu.setLayoutX(1000);
        this.gridMenu.setLayoutY(10);
    }

    private void createButtons() {
        this.start = new Button();
        this.player = new Button();

        start.setText("Start Game");
        start.setLayoutX(880);
        start.setLayoutY(60);

        player.setText("Create Player");
        player.setLayoutX(880);
        player.setLayoutY(20);
    }
}
