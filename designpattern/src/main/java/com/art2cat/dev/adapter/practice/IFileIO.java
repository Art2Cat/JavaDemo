package com.art2cat.dev.adapter.practice;

import java.io.IOException;
import java.nio.file.Path;

/**
 * com.art2cat.dev.adapter.practice
 *
 * @author art2c
 * @date 5/15/2018
 */
public interface IFileIO {

    void readFromFile(Path filePath) throws IOException;

    void writeToFile(Path filePath) throws IOException;

    void setValue(String key, String value);

    String getValue(String key);
}
