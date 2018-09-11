package com.art2cat.dev.nio;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

public class TmpFileCreator implements Callable<File> {
    private String tmpPath;
    private File createdFile;

    public TmpFileCreator(String tmpPath) {
        this.tmpPath = tmpPath;
    }

    @Override
    public File call() {
        try {
            Thread.sleep(1000);
            System.out.println("Creating file");
            createdFile = new File(tmpPath + "/MyFileSema.For");
            createdFile.createNewFile();
            return createdFile;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
