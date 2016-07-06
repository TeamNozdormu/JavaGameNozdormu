package com.company.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    private int cropWidth;
    private int cropHeight;

    public SpriteSheet(BufferedImage sheet, int cropWidth, int cropHeight) {
        this.sheet = sheet;
        this.cropWidth = cropWidth;
        this.cropHeight = cropHeight;
    }

    //Method that crops the image from x to width and from y to height
    public BufferedImage crop(int x, int y) {
        //Returns a new image in the area we specified
        return sheet.getSubimage(x * this.cropWidth, y * this.cropHeight, this.cropWidth, this.cropHeight);
    }
}
