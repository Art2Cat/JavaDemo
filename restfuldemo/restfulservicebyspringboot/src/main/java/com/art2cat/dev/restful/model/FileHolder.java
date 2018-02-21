package com.art2cat.dev.restful.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * com.art2cat.dev.restful.model
 *
 * @author Rorschach
 * @date 11/01/2018
 */
public class FileHolder {
    
    private String fileName;
    private byte[] fileContent;
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public byte[] getFileContent() {
        return fileContent;
    }
    
    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileHolder that = (FileHolder) o;
        return Objects.equals(fileName, that.fileName) &&
            Arrays.equals(fileContent, that.fileContent);
    }
    
    @Override
    public int hashCode() {
        
        int result = Objects.hash(fileName);
        result = 31 * result + Arrays.hashCode(fileContent);
        return result;
    }
}
