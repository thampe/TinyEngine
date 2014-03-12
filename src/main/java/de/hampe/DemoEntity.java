package de.hampe;

import de.hampe.te.entity.Entity;

import java.awt.*;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-12
 */
public class DemoEntity extends Entity{

    public DemoEntity(float x, float y) {
        super("test.png", x, y);
    }

    public void draw(Graphics context) {
        super.draw(context);
        String position = String.format("x:%d, y:%d", (int)getX(), (int) getY());
        context.drawString(position, (int) getX()+5, (int) getY()+15);
    }

}
