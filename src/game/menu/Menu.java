package game.menu;

import game.player.Personality;
import game.player.Player;
import game.player.Type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Menu {
    private Group group;
    private Player playerGame;

    public Menu(Group group, Player playerGame) {
        this.group = group;
        this.playerGame = playerGame;
        group.getChildren().add(this.createButton());
        group.getChildren().add(this.createGridMenu());
    }

    public void updateGridMenu() {
        //this.group.getChildren().remove(2)
        System.out.println("update grid");
    }

    private GridPane createGridMenu() {
        GridPane gridMenu = new GridPane();
        gridMenu.setPadding(new Insets(5));
        gridMenu.setHgap(5);
        gridMenu.setVgap(5);
        ColumnConstraints columnOne = new ColumnConstraints(100);
        ColumnConstraints columnTwo = new ColumnConstraints(50, 100, 200);
        gridMenu.getColumnConstraints().addAll(columnOne, columnTwo);

        Label health = new Label("Health:");
        health.setTextFill(Color.web("#FFFFFF"));
        Label healthValue = new Label(Personality.HEALTH_DEFAULT + "");
        healthValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(health, HPos.LEFT);
        GridPane.setHalignment(healthValue, HPos.RIGHT);
        gridMenu.add(health, 0, 0);
        gridMenu.add(healthValue, 1, 0);

        Label attack = new Label("Attack:");
        attack.setTextFill(Color.web("#FFFFFF"));
        Label attackValue = new Label(Personality.ATTACK_DEFAULT + "");
        attackValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(attack, HPos.LEFT);
        GridPane.setHalignment(attackValue, HPos.RIGHT);
        gridMenu.add(attack, 0, 1);
        gridMenu.add(attackValue, 1, 1);

        Label defence = new Label("Defence:");
        defence.setTextFill(Color.web("#FFFFFF"));
        Label defenceValue = new Label(Personality.DEFENCE_DEFAULT + "");
        defenceValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(defence, HPos.LEFT);
        GridPane.setHalignment(defenceValue, HPos.RIGHT);
        gridMenu.add(defence, 0, 2);
        gridMenu.add(defenceValue, 1, 2);

        Label experience = new Label("Experience:");
        experience.setTextFill(Color.web("#FFFFFF"));
        Label experienceValue = new Label(Personality.EXPERIENCE_DEFAULT + "");
        experienceValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(experience, HPos.LEFT);
        GridPane.setHalignment(experienceValue, HPos.RIGHT);
        gridMenu.add(experience, 0, 3);
        gridMenu.add(experienceValue, 1, 3);
        gridMenu.setLayoutX(1000);
        gridMenu.setLayoutY(10);

        return gridMenu;
    }

    private Button createButton() {
        Button player = new Button();
        player.setText("Create Player");
        player.setLayoutX(880);
        player.setLayoutY(20);
        player.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextField user = new TextField();
                user.setPromptText("Username");

                Button start = new Button();
                start.setText("Start Game");
                start.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String username = user.getText();
                        Menu.this.playerGame = new Player(username, Type.USER);
                        Menu.this.group.getChildren().remove(3); //remove grid with username field
                        //TODO render again status menu
                    }
                });

                GridPane grid = new GridPane();
                grid.setLayoutX(450);
                grid.setLayoutY(350);
                grid.setVgap(5);
                grid.setHgap(5);
                grid.setPadding(new Insets(5, 5, 5, 5));
                grid.add(user, 0, 0);
                grid.add(start, 1, 0);

                Menu.this.group.getChildren().add(grid);
            }
        });

        return player;
    }
}
