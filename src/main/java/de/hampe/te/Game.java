package de.hampe.te;

import de.hampe.te.graphics.RenderInterface;
import de.hampe.te.logic.UpdateInterface;

import java.awt.*;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-10
 */
public class Game {

    private UpdateInterface updater;

    private RenderInterface renderer;

    private long lastLoop;

    // wait after every repaint
    private int delay;

    public Game(String title, int width, int height) {
        Window.singleton(title, width, height);
        lastLoop = 0;
        delay = 10;
    }

    public Game(String title, int width, int height, UpdateInterface updater, RenderInterface renderer) {
        this(title, width, height);
        setUpdater(updater);
        setRenderer(renderer);
    }

    public void setRenderer(RenderInterface renderer) {
        this.renderer = renderer;
    }

    public void setUpdater(UpdateInterface updater) {
        this.updater = updater;
    }

    public void run() {
        // load some font(s)

        //FontManager.loadFont("fonts/PressStart2P-Regular.ttf", "PressStart2P-Regular");
        while(true) {
            lastLoop = Timer.getTime();
            //update
            if(updater != null) {
                updater.update();
            }
            //render
            int height = Window.singleton().getHeight();
            int width = Window.singleton().getWidth();
            Graphics2D context = Window.singleton().getGraphicsContext();
            context.setColor(Color.black);
            context.fillRect(0, 0, width, height);

            if(renderer != null) {
                renderer.render(context);
            }

            Window.singleton().repaint();
            long delta = lastLoop+delay-Timer.getTime();
            if(delta > 0) {
                Timer.sleep(delta);
            }
        }
    }

}

