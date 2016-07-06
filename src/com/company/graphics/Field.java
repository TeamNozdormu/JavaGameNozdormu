package com.company.graphics;

import java.awt.image.BufferedImage;

public class Field {
    private int startX;
    private int startY;
    private BufferedImage picture;

    public Field(int x, int y, BufferedImage fieldPicture) {
        this.setX(x);
        this.setY(y);
        this.setPicture(fieldPicture);
    }

    public int getX() {
        return this.startX;
    }

    private void setX(int x) {
        this.startX = x;
    }

    public int getY() {
        return this.startY;
    }

    private void setY(int y) {
        this.startY = y;
    }

    public BufferedImage getPicture() {
        return this.picture;
    }

    private void setPicture(BufferedImage picture) {
        this.picture = picture;
    }
}
