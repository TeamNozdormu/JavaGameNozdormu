package com.company.graphics;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {

    //TODO: Implement loading images from path and returnig them to the caller
    public static BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;

    }

}
