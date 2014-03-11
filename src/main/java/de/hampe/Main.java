package de.hampe;

import de.hampe.te.Core;
import de.hampe.te.FontManager;
import de.hampe.te.Game;
import de.hampe.te.Timer;
import de.hampe.te.entity.Entity;
import de.hampe.te.input.Keyboard;


import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-08
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game("Tiny Graphics Lib (alpha)", 800, 600);

        game.setRenderer(new DemoRenderer());
        game.run();

        /*Core.run("Tiny Graphics Lib (alpha)", 800, 600);
        Graphics2D g = de.hampe.te.Window.singleton().getGraphicsContext();
        g.setColor(Color.white);
        g.fillRect(0,0,800,600);
        Entity e = new Entity("test.png", 20, 20);
        e.setLocation( 400 - e.getWidth()/2, 300 - e.getHeight()/2);

        e.draw(g);
        de.hampe.te.Window.singleton().repaint();
        while (true) {
            if(Keyboard.isPressed(KeyEvent.VK_W)) {
                Core.log("Foooo");
            }
            Timer.sleep(10);
            de.hampe.te.Window.singleton().repaint();
        }*/
    }

}
