package com.art2cat.dev.corejava.gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 * Created by Rorschach on 2017/3/31.
 */
public class SwingTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleFrame frame = new SimpleFrame();

            frame.setTitle("Fuck you!");

            frame.setLocation(256, 256);

            Image img = new ImageIcon("C:\\Users\\Rorschach\\Downloads\\icon.jpg").getImage();
            frame.setIconImage(img);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
