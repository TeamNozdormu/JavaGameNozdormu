package com.company.graphics;

import javax.swing.*;
import java.awt.*;

public class Display {

    private int width;
    private int height;
    private String title;
    private JFrame frame;
    private Canvas canvas;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Display(String title, int width, int height) {
        this.setTitle(title);
        this.setWidth(width);
        this.setHeight(height);
        initDisplay();
    }

    private void initDisplay() {
        this.setFrame(new JFrame(this.getTitle()));
        this.getFrame().setSize(this.getWidth(), this.getHeight());
        this.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getFrame().setResizable(false);
        this.getFrame().setLocationRelativeTo(null);
        this.getFrame().setVisible(true);
        this.getFrame().setFocusable(true);

        this.setCanvas(new Canvas());
        this.getCanvas().setSize(this.getWidth(), this.getHeight());
        this.getCanvas().setMaximumSize(new Dimension(this.getWidth(), this.getHeight()));
        this.getCanvas().setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
        this.getFrame().add(this.getCanvas());
        this.getFrame().pack();
    }
}