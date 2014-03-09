package de.hampe;

import de.hampe.core.Core;
import de.hampe.core.entity.Entity;


import java.awt.*;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-08
 */
public class Main {

    public static void main(String[] args) {
        Core.run("Tiny Graphics Lib (alpha)", 800, 600);
        Graphics2D g = de.hampe.core.Window.singleton().getGraphicsContext();
        g.setColor(Color.white);
        g.fillRect(0,0,800,600);
        Entity e = new Entity("test.png", 20, 20);
        e.setLocation( 400 - e.getWidth()/2, 300 - e.getHeight()/2);

        e.draw(g);
        de.hampe.core.Window.singleton().repaint();
    }

}
