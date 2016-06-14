package com.company.graphics;

import com.company.game.AbstractObjects.GameObject;

import javax.swing.*;
import java.awt.*;

public class Display {

    private int width;
    private int height;
    private String title;

    private JFrame frame;
    private Canvas canvas;

    public Display(String title, int width, int height) {

        this.title = title;
        this.width = width;
        this.height = height;

        initDisplay();

    }

    private void initDisplay(){

        this.frame = new JFrame(this.title);
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setFocusable(true);

        this.canvas = new Canvas();
        this.canvas.setSize(this.width, this.height);
        this.canvas.setMaximumSize(new Dimension(width, height));
        this.canvas.setMinimumSize(new Dimension(width, height));

        this.frame.add(this.canvas);

        this.frame.pack();

    }

    public Canvas getCanvas(){
        return this.canvas;
    }

}
