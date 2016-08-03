package com.company.gameobjects.base;

import com.company.gameobjects.interfaces.GameObject;
import com.company.interfaces.Displayable;
import com.company.interfaces.Updateable;

import java.awt.*;
import java.awt.image.BufferedImage;

//Note: If you extend the class and want to push the path from the child
//      you must add it's path to the ImageAlbum and take it from there in the concrete child class.

public abstract class AbstractGameObject implements GameObject, Displayable, Updateable {

    private int x;
    private int y;
    private int speed;
    private Rectangle colliderBox;
    private BufferedImage gameObjectIcon;

    public AbstractGameObject(int x, int y, BufferedImage gameObjectIcon, int speedMultiplier) {
        this.setX(x);
        this.setY(y);
        this.setSpeed(speedMultiplier);
        this.setObjectIcon(gameObjectIcon);
        this.setColliderBox(new Rectangle(
                        this.x,
                        this.y,
                        this.gameObjectIcon.getWidth(),
                        this.gameObjectIcon.getHeight()
                )
        );
    }

    public AbstractGameObject(BufferedImage bufferedImage) {

    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getObjectIcon() {
        return this.gameObjectIcon;
    }

    private void setObjectIcon(BufferedImage gameObjectIcon) {
        this.gameObjectIcon = gameObjectIcon;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Rectangle getColliderBox() {
        return colliderBox;
    }

    public void setColliderBox(Rectangle colliderBox) {
        this.colliderBox = colliderBox;
    }

    public boolean collide(Rectangle r) {
        if (this.getColliderBox().intersects(r)) {
            return true;
        }

        return false;
    }

    @Override
    public void display(Graphics g) {
        g.drawImage(this.getObjectIcon(), this.getX(), this.getY(), null);
    }

    @Override
    public void update() {

    }
}