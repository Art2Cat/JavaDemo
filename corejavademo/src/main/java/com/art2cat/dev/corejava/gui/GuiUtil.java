package com.art2cat.dev.corejava.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Created by Rorschach on 2017/3/31.
 */
public class GuiUtil {

    Dimension getScreenDimension() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return toolkit.getScreenSize();
    }
}
