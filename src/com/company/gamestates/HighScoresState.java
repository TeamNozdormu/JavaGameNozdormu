package com.company.gamestates;

import com.company.gameobjects.entities.Button;
import com.company.graphics.Assets;

import java.awt.*;

import java.util.Map;

public class HighScoresState extends State {

    private static final int ROW_HEIGHT = 35;
    private int row = 0;
    //private static Button backButton = new Button(300, 470, Assets.button, "Main menu");
    private static Button backButton = new Button(100, 470, Assets.button, "Main menu");
    private static Button reverse = new Button(400, 470, Assets.button, "Reverse");
    private int backButtonXPos;
    private int reverseButtonXPos;
    private String currentSortingOrder;

    public HighScoresState(String order) {
    	this.setCurrentSortingOrder(order);
    	
    	if (this.getCurrentSortingOrder().equals("Descending")) {
			Assets.loadingHighScores();
		} else if (this.getCurrentSortingOrder().equals("Ascending")) {
			Assets.loadHighScoresAscending();
		}
    	
        backButtonXPos = -220;
        reverseButtonXPos = -220;
        backButton.setX(backButtonXPos);
        reverse.setX(reverseButtonXPos);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getBackButtonXPos() {
        return backButtonXPos;
    }

    public void setBackButtonXPos(int backButtonXPos) {
        this.backButtonXPos = backButtonXPos;
    }
    
    public String getCurrentSortingOrder() {
    	return this.currentSortingOrder;
    }
    
    private void setCurrentSortingOrder(String order) {
    	this.currentSortingOrder = order;
    }

    public static int getRowHeight() {
        return ROW_HEIGHT;
    }

    public static Button getBackButton() {
        return backButton;
    }
    
    public static Button getReverseButton() {
    	return reverse;
    }
    
    public void reverseOrder() {
    	if (this.currentSortingOrder.equals("Ascending")) {
			this.currentSortingOrder = "Descending";
			Assets.loadingHighScores();
		} else if (this.currentSortingOrder.equals("Descending")) {
			this.currentSortingOrder = "Ascending";
			Assets.loadHighScoresAscending();
		}
    }

    @Override
    public void update() {

        if(backButtonXPos < 100) {
            backButtonXPos += 10;
            backButton.setX(backButtonXPos);
        }
        
        if(reverseButtonXPos < 400) {
        	reverseButtonXPos += 10;
        	reverse.setX(reverseButtonXPos);
        }
    }

    @Override
    public void display(Graphics g) {

        Font blackout = new Font("redensek", Font.PLAIN, 40);
        g.setFont(blackout);
        FontMetrics fontMetrics = g.getFontMetrics();
        g.setColor(Color.green);
        g.drawImage(Assets.highScoresBackground, 0, 0, null);
        g.drawString("High Scores", 330, 50);
        g.drawString("Name",130, 85);
        g.drawString("score", 700 - fontMetrics.stringWidth("score"), 85);
        g.setColor(Color.white);

        for (Map.Entry<String, Integer> entry : Assets.highScores.entrySet()) {
            row++;
            g.drawString(String.valueOf(row) + ".", 80, 95 + ROW_HEIGHT * row);
            g.drawString(entry.getKey(), 130, 95 + ROW_HEIGHT * row);
            String str = String.valueOf(entry.getValue());
            g.drawString(String.format("%d", entry.getValue()), 700 - fontMetrics.stringWidth(str), 95 + ROW_HEIGHT * row);

            if (row == 10) {
                break;
            }
        }

        row = 0;
        g.setColor(Color.GREEN);
        g.drawImage(Assets.buttonBar, -20, backButton.getY() + 35, null);
        g.drawImage(Assets.buttonBar, -20, reverse.getY() + 35, null);
        backButton.display(g);
        reverse.display(g);

    }

}

