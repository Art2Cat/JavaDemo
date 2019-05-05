package com.art2cat.dev.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * com.art2cat.dev.flyweight
 *
 * @author art2c
 * @date 6/14/2018
 */
public class BigChar {

    private String charName;
    private String fontData;

    public BigChar(String charName) {
        this.charName = charName;

        try (FileReader reader = new FileReader(
            Paths.get("src", "main", "resources", "big" + charName + ".txt").toString())) {
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line).append("\n");
                }
                this.fontData = builder.toString();
            }
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}
