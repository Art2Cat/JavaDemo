package com.art2cat.dev.adapter.practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * com.art2cat.dev.adapter.practice
 *
 * @author art2c
 * @date 5/15/2018
 */
public class FileProperties implements IFileIO {

    private Properties properties;

    public FileProperties() {
        this.properties = new Properties();
    }

    @Override
    public void readFromFile(Path filePath) throws IOException {
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        Reader reader = new FileReader(filePath.toFile());
        properties.load(reader);
    }

    @Override
    public void writeToFile(Path filePath) throws IOException {
        Writer writer = new FileWriter(filePath.toString());
        properties.store(writer, "test");
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
