package de.hampe.te.logic;

import de.hampe.te.Timer;

import java.awt.*;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-11
 */
public class Fps {

    private static Fps instance;

    private long lastUpdated;

    private int framesCount;

    private int fps;

    private Fps() {
        this.lastUpdated = Timer.getTime();
        this.framesCount = 0;
        this.fps = 0;
    }

    public static Fps singleton() {
        if(Fps.instance == null){
            Fps.instance = new Fps();
        }
        return Fps.instance;
    }

    public void draw(Graphics2D context) {
        updateFps();
        context.setColor(Color.green);
        context.drawString(fps+"FPS", 1, 15);

    }

    private void updateFps() {
        long now = Timer.getTime();
        framesCount++;
        if(now - lastUpdated >= 1000) {
            fps = framesCount;
            framesCount = 0;
            lastUpdated = now;
        }
    }

}
