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
        Game game = new Game("Tiny Graphics Lib (alpha)", 1024, 600);
        game.setRenderer(new DemoRenderer());
        game.run();
    }

}
