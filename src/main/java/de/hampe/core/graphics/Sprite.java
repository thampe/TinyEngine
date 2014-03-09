package de.hampe.core.graphics;

import de.hampe.core.Core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-09
 */
public class Sprite {
    /** The image to be drawn for this sprite */
    private Image image;

    /**
     * Create a new sprite based on an image
     *
     * @param url The url that is the path th sprite
     */
    public Sprite(URL url) {
        BufferedImage sourceImage = null;
        try {
            sourceImage = ImageIO.read(url);
        }
        catch (IOException e) {
            Core.log(e.getMessage());

        }

        Image image = null;
        try {
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            image = gc.createCompatibleImage(sourceImage.getWidth(),sourceImage.getHeight(),Transparency.BITMASK);
            // draw our source image into the accelerated image
            image.getGraphics().drawImage(sourceImage,0,0,null);
        }catch (NullPointerException e) {
            //should never because of sourceImage is surrounded by try catch
            Core.log("You failed, go home!!!");
        }


        this.image = image;
    }

    /**
     * Get the width of the drawn sprite
     *
     * @return The width in pixels of this sprite
     */
    public int getWidth() {
        return image.getWidth(null);
    }

    /**
     * Get the height of the drawn sprite
     *
     * @return The height in pixels of this sprite
     */
    public int getHeight() {

        return image.getHeight(null);
    }

    /**
     * Draw the sprite onto the graphics context provided
     *
     * @param g The graphics context on which to draw the sprite
     * @param x The x location at which to draw the sprite
     * @param y The y location at which to draw the sprite
     */
    public void draw(Graphics g,int x,int y) {
        g.drawImage(image,x,y,null);
    }
}
