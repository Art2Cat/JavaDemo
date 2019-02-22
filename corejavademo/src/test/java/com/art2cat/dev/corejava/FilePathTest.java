package com.art2cat.dev.corejava;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilePathTest {

    @Test
    public void test() {
        Path path = Paths.get("src", "test", "resources").toAbsolutePath();
        System.out.println(path.toString());

        path = Paths.get(path.toString(), "text.txt").toAbsolutePath();

        System.out.println(path.toString());

        if (path.getFileName().endsWith("text.txt")) {
            System.out.println(String.format("file name: %s", path.getFileName().toString()));
        }
        if (Files.notExists(path)) {
            Assertions.fail();
        }
    }
}

