package com.art2cat.dev.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateFileTest {

    Path path = Paths.get("src", "test", "resources", "tmp.txt");

    @Test
    public void testCreate() {

        try {
            Files.createFile(path);
        } catch (IOException x) {
            Assertions.fail(x);
        }
    }

    @Test
    public void testDelete() {
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException x) {
            Assertions.fail(x);
        }
    }
}
