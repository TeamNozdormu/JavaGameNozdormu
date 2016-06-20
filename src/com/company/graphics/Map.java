package com.company.graphics;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Map {
    private int width;
    private int height;
    private TreeMap<int[][], Field> map;
    private List<Field> fields;

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

    public List<Field> getFields() {
        return this.fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Map(int width, int height) {
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
                this.getFields().add(new Field(row, coll));
            }
        }
    }

    private void generationOnMap() {
        //TODO generate map with picture - random
    }
}
