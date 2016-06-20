package com.company.graphics;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class GameMap {
    private int width;
    private int height;
    private TreeMap<int[][], Field> map;
    private List<Field> fields;

    public int getWidth() {
        return this.width;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public List<Field> getFields() {
        return this.fields;
    }

    private void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public GameMap(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.setFields(new LinkedList<>());
        this.init();
    }

    private void init() {
        this.generationFields();
        this.generationOnMap();
    }

    private void generationFields() {
        for (int row = 0; row < this.getWidth(); row+=20) {
            for (int coll = 0; coll < this.getHeight(); coll+=20) {
                BufferedImage field = ImageLoader.loadImage(ImageAlbum.Field.getPath());
                this.getFields().add(new Field(row, coll, field));
            }
        }
    }

    private void generationOnMap() {
        //TODO generate map with picture - random
    }
}
