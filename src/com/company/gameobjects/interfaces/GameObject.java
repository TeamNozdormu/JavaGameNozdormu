package com.company.gameobjects.interfaces;


import java.awt.*;
import java.awt.image.BufferedImage;

public interface GameObject {

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    BufferedImage getObjectIcon();

    int getSpeed();

    void setSpeed(int speed);

    Rectangle getColliderBox();

    void setColliderBox(Rectangle colliderBox);

    boolean collide(Rectangle r);
}
