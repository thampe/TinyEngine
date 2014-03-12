package de.hampe;

import de.hampe.te.*;
import de.hampe.te.entity.Entity;
import de.hampe.te.graphics.RenderInterface;
import de.hampe.te.input.Keyboard;
import de.hampe.te.input.Mouse;
import de.hampe.te.logic.Fps;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-10
 */
public class DemoRenderer implements RenderInterface{

    protected DemoEntity e;

    public void render(Graphics2D context) {
        context.setColor(Color.white);
        context.fillRect(0, 0, de.hampe.te.Window.singleton().getWidth(), de.hampe.te.Window.singleton().getWidth());
        if(e == null) {
            e = new DemoEntity(20, 20);
            e.setLocation( 400 - e.getWidth()/2, 300 - e.getHeight()/2);
        }
        int fps = Fps.singleton().getFps();
        if(Keyboard.isPressed(KeyEvent.VK_LEFT)) {
            e.move(-200.0f/fps,0.0f);
        }
        if(Keyboard.isPressed(KeyEvent.VK_RIGHT)) {
            e.move(200.0f/fps,0.0f);
        }
        if(Keyboard.isPressed(KeyEvent.VK_UP)) {
            e.move(0.0f, -200.0f/fps);
        }
        if(Keyboard.isPressed(KeyEvent.VK_DOWN)) {
            e.move(0.0f, 200.0f/fps);
        }






        e.draw(context);
        Fps.singleton().draw(context);
        Mouse.drawLocation(context);
    }

}
