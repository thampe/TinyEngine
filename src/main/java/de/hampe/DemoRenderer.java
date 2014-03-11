package de.hampe;

import de.hampe.te.Timer;
import de.hampe.te.entity.Entity;
import de.hampe.te.graphics.RenderInterface;
import de.hampe.te.logic.Fps;

import java.awt.*;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-10
 */
public class DemoRenderer implements RenderInterface{

    public void render(Graphics2D context) {
        context.setColor(Color.white);
        context.fillRect(0, 0, 800, 600);
        Entity e = new Entity("test.png", 20, 20);
        e.setLocation( 400 - e.getWidth()/2, 300 - e.getHeight()/2);
        Fps.singleton().draw(context);
        e.draw(context);
        //Timer.sleep(100/6);
    }

}
