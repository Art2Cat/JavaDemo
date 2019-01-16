package com.art2cat.dev.corejava.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Created by Rorschach on 2017/3/31.
 */
public class SimpleFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public SimpleFrame() {
        add(new NotHelloWorldComponent());
        pack();
        GuiUtil guiUtil = new GuiUtil();
        setSize(guiUtil.getScreenDimension().width / 2, guiUtil.getScreenDimension().height / 2);
    }
}

class NotHelloWorldComponent extends JComponent {

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.drawString("Not a hello, this is Fuck message.", 200, 200);
    }

    public Dimension getPreferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
