package com.company.graphics;

public class Field {
    private int x;
    private int y;

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

    public Field(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
