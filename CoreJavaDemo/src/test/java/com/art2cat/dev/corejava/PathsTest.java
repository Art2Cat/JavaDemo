package com.art2cat.dev.corejava;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class PathsTest {
    
    @Test
    public void test() {
        Path path = Paths.get("").toAbsolutePath();
        System.out.println(path.toString());
        
        path = Paths.get("text.txt").toAbsolutePath();
        
        System.out.println(path.toString());
        
        if (path.getFileName().endsWith("text.txt")) {
            System.out.println(String.format("file name: %s", path.getFileName().toString()));
        }
    }
    
    @Test
    public void test1() {
        URL url = this.getClass().getClassLoader().getResource("text.txt");
        if (url == null) {
            Assert.fail();
        }
        
        String path = url.getPath();
        System.out.println(path);
        
        URL image = this.getClass().getClassLoader().getResource("google.jpg");
        if (image == null) {
            Assert.fail();
        }
        
        try {
            Path path1 = Paths.get(image.toURI());
            System.out.println(path1.toString());
            Assert.assertTrue(Files.exists(path1));
        } catch (URISyntaxException e) {
            Assert.fail(e.getMessage());
        }
        
        Long number = 18658710313L;
        
        System.out.println(String.valueOf(number).length());
    }
}
