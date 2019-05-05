package com.art2cat.dev.bridge.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * com.art2cat.dev.bridge.impl
 *
 * @author art2c
 * @date 5/28/2018
 */
public class TextDisplayImpl extends AbstractRawDisplay {

    private final Path path;
    private List<String> allLines;

    public TextDisplayImpl(Path path) {
        this.path = path;
    }

    @Override
    public void rawOpen() {
        try {
            allLines = Files.readAllLines(path, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Opened file: " + path.toString());
    }

    @Override
    public void rawPrint() {
        if (allLines != null && !allLines.isEmpty()) {
            allLines.forEach(System.out::println);
        }
    }

    @Override
    public void rawClose() {
        allLines.clear();
        System.out.println("Closed file: " + path.toString());
    }
}
