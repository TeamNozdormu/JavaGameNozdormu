package com.company.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    private int cropWidth;
    private int cropHeight;

    public SpriteSheet(BufferedImage sheet, int cropWidth, int cropHeight) {
        this.setSheet(sheet);
        this.setCropWidth(cropWidth);
        this.setCropHeight(cropHeight);
    }

    public BufferedImage getSheet() {
        return sheet;
    }

    private void setSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public int getCropWidth() {
        return cropWidth;
    }

    private void setCropWidth(int cropWidth) {
        this.cropWidth = cropWidth;
    }

    public int getCropHeight() {
        return cropHeight;
    }

    private void setCropHeight(int cropHeight) {
        this.cropHeight = cropHeight;
    }

    //Method that crops the image from x to width and from y to height
    public BufferedImage crop(int x, int y) {
        //Returns a new image in the area we specified
        return sheet.getSubimage(x * this.getCropWidth(), y * this.getCropHeight(), this.getCropWidth(), this.getCropHeight());
    }
}
