package  de.hampe.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

/**
 * @author Thomas Hampe <thomas@hampe.co>
 * @version 1.0
 * @since 2014-03-08
 */
public class Window extends Canvas{

    private BufferStrategy strategy;

    private static Window instance;

    public static Window singleton() {
        return singleton("Window", 800, 600);
    }

    public static Window singleton(String title, int width, int height) {
        if(Window.instance == null) {
            Window.instance = new Window(title, width, height);
        }
        return Window.instance;
    }

    public Window(String title, int width, int height) {

        JFrame frame = new JFrame(title);

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(width,height));
        setBounds(0,0,width,height);
        panel.add(this);

        //ignore refresh
        setIgnoreRepaint(true);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Core.exit(0);
            }
        });

        requestFocus();
        /*
         *   create the buffering strategy which will allow AWT
         *   to manage our accelerated graphics
         */
        createBufferStrategy(2);
        strategy = getBufferStrategy();

    }

    public Graphics2D getGraphicsContext() {
        return (Graphics2D) strategy.getDrawGraphics();
    }

    public void repaint() {
        getGraphicsContext().dispose();
        strategy.show();
    }
}
