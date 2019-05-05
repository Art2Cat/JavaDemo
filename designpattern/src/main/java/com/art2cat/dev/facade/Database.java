package com.art2cat.dev.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * com.art2cat.dev.facade
 *
 * @author art2c
 * @date 6/5/2018
 */
public class Database {

    private Database() {
    }

    public static Properties getProperties(String dbName) {
        String fileName = dbName + ".txt";
        Properties properties = new Properties();
        try {
            properties.load(
                new FileInputStream(Paths.get("src", "main", "resources", fileName).toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
