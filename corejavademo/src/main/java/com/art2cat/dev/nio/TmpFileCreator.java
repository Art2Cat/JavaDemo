package com.art2cat.dev.nio;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class TmpFileCreator implements Callable<File> {

    private final String tmpPath;

    public TmpFileCreator(String tmpPath) {
        this.tmpPath = tmpPath;
    }

    @Override
    public File call() {
        try {
            Thread.sleep(1000);
            System.out.println("Creating file");
            File createdFile = new File(tmpPath + "/MyFileSema.For");
            if (createdFile.createNewFile()) {
                return createdFile;
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
