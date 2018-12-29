package com.art2cat.dev.java8;

import java.io.File;
import java.io.FileFilter;

public class ListHiddenFile {
    
    public File[] listHiddenFileOld(File directory) {
        return directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
    }
    
    public File[] listHiddenFile(File directory) {
        return directory.listFiles(File::isHidden);
    }
}
