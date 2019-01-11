package com.art2cat.dev.corejava.iostream;

import java.io.File;

/**
 * Created by Rorschach on 08/05/2017.
 */
public class FileUtils {

    public static FileUtils instance;

    private FileUtils() {

    }

    synchronized public static FileUtils getInstance() {
        if (instance != null) {
        } else {
            instance = new FileUtils();
        }
        return instance;
    }

    public static FileUtils getUtil() {
        synchronized (FileUtils.class) {
            if (instance == null) {
                instance = new FileUtils();
            }
            return instance;
        }
    }

    public static FileUtils get() {
        if (instance != null) {

        } else {
            synchronized (FileUtils.class) {
                if (instance == null) {
                    instance = new FileUtils();
                }
            }
        }
        return instance;
    }

    public void listDirectory(File dir) {

        if (!dir.exists()) {
            throw new IllegalArgumentException("dir no found!");
        }

        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("dir is not a directory!");

        }

        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.exists() && file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }

    }

    public boolean isWindows() {
        return System.getProperty("os.name").equals("Windows");
    }
}
