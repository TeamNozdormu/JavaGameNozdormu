package com.company.graphics;

public class Map {
    private int width;
    private int height;
    private int[][] map;

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

    public int[][] getMap() {
        return this.map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public Map(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.setMap(new int[this.getWidth()][this.getHeight()]);
    }

    private void init() {

    }
}
