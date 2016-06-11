package game.menu;

import game.Main;
import game.player.classes.Person;
import game.player.classes.Personality;
import game.player.classes.Player;
import game.player.enumeration.Type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Menu {
    private Button player;
    private GridPane grid;
    private Group group;
    private Person playerGame;
    private GridPane gridMenu;

    public Menu(Group group, Person playerGame) {
        this.group = group;
        this.playerGame = playerGame;
        renderGridMenu();
        createButton();
    }

    public void renderGridMenu() {
        if (this.gridMenu != null) {
            this.group.getChildren().removeAll(this.gridMenu);
        }

        int healthPoints = 0;
        int attackPoints = 0;
        int defencePoints = 0;
        int experiencePoints = 0;

        this.gridMenu = new GridPane();
        this.gridMenu.setPadding(new Insets(5));
        this.gridMenu.setHgap(5);
        this.gridMenu.setVgap(5);
        ColumnConstraints columnOne = new ColumnConstraints(100);
        ColumnConstraints columnTwo = new ColumnConstraints(50, 100, 200);
        this.gridMenu.getColumnConstraints().addAll(columnOne, columnTwo);

        if (this.playerGame == null) {
            healthPoints = Personality.HEALTH_DEFAULT;
            attackPoints = Personality.ATTACK_DEFAULT;
            defencePoints = Personality.DEFENCE_DEFAULT;
            experiencePoints = Personality.EXPERIENCE_DEFAULT;
        } else {
            healthPoints = this.playerGame.getHealth();
            attackPoints = this.playerGame.getAttack();
            defencePoints = this.playerGame.getDefence();
            experiencePoints = this.playerGame.getExperience();

            Label user = new Label("Username:");
            user.setTextFill(Color.web("#FFFFFF"));
            Label userName = new Label(this.playerGame.getPlayerName());
            userName.setTextFill(Color.web("#A40013"));
            GridPane.setHalignment(user, HPos.LEFT);
            GridPane.setHalignment(userName, HPos.RIGHT);
            this.gridMenu.add(user, 0, 4);
            this.gridMenu.add(userName, 1, 4);

        }

        Label health = new Label("Health:");
        health.setTextFill(Color.web("#FFFFFF"));
        Label healthValue = new Label(healthPoints + "");
        healthValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(health, HPos.LEFT);
        GridPane.setHalignment(healthValue, HPos.RIGHT);
        this.gridMenu.add(health, 0, 0);
        this.gridMenu.add(healthValue, 1, 0);

        Label attack = new Label("Attack:");
        attack.setTextFill(Color.web("#FFFFFF"));
        Label attackValue = new Label(attackPoints + "");
        attackValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(attack, HPos.LEFT);
        GridPane.setHalignment(attackValue, HPos.RIGHT);
        this.gridMenu.add(attack, 0, 1);
        this.gridMenu.add(attackValue, 1, 1);

        Label defence = new Label("Defence:");
        defence.setTextFill(Color.web("#FFFFFF"));
        Label defenceValue = new Label(defencePoints + "");
        defenceValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(defence, HPos.LEFT);
        GridPane.setHalignment(defenceValue, HPos.RIGHT);
        this.gridMenu.add(defence, 0, 2);
        this.gridMenu.add(defenceValue, 1, 2);

        Label experience = new Label("Experience:");
        experience.setTextFill(Color.web("#FFFFFF"));
        Label experienceValue = new Label(experiencePoints + "");
        experienceValue.setTextFill(Color.web("#A40013"));
        GridPane.setHalignment(experience, HPos.LEFT);
        GridPane.setHalignment(experienceValue, HPos.RIGHT);
        this.gridMenu.add(experience, 0, 3);
        this.gridMenu.add(experienceValue, 1, 3);
        this.gridMenu.setLayoutX(1000);
        this.gridMenu.setLayoutY(10);

        this.group.getChildren().add(this.gridMenu);
    }

    private void createButton() {
        this.player = new Button();
        this.player.setText("Create Player");
        this.player.setLayoutX(880);
        this.player.setLayoutY(20);
        this.player.setOnAction(new EventHandler<ActionEvent>() {
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
                        Menu.this.playerGame = new Player(username, Type.USER, 25, 25, new Image(Main.PLAYER_IMAGE));
                        Menu.this.group.getChildren().remove(Menu.this.grid);       //remove grid with username field
                        Menu.this.group.getChildren().remove(Menu.this.player);  //remove button for create player
                    }
                });

                Menu.this.grid = new GridPane();
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
        group.getChildren().add(this.player);
    }
}
