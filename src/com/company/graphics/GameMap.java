package com.company.graphics;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class GameMap {
    private int width;
    private int height;
    private TreeMap<String, Field> map;
    private List<Field> fields;

    public GameMap(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        fields = new LinkedList<>();
        map = new TreeMap<>();
        this.init();
    }

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

    public TreeMap<String, Field> getMap() {
       return this.map;
    }

    private void init() {
        this.generationFields();
    }

    private void generationFields() {
        for (int row = 0; row < this.getWidth(); row+=20) {
            for (int coll = 0; coll < this.getHeight(); coll+=20) {
                BufferedImage fieldPicture = ImageLoader.loadImage(ImageAlbum.Field.getPath());
                Field field = new Field(row, coll, fieldPicture);
                this.getFields().add(field);
                this.generationOnMap(row, coll, field);
            }
        }
    }

    private void generationOnMap(int x, int y, Field field) {
        StringBuilder coordinates = new StringBuilder();
        coordinates.append(x);
        coordinates.append(",");
        coordinates.append(y);
        this.getMap().put(coordinates.toString(), field);
        //TODO generate map with picture - random
    }
}
