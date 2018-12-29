package com.art2cat.dev.corejava;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
            Assertions.fail();
        }
        
        String path = url.getPath();
        System.out.println(path);
        
        URL image = this.getClass().getClassLoader().getResource("google.jpg");
        if (image == null) {
            Assertions.fail();
        }
        
        try {
            Path path1 = Paths.get(image.toURI());
            System.out.println(path1.toString());
            Assertions.assertTrue(Files.exists(path1));
        } catch (URISyntaxException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
