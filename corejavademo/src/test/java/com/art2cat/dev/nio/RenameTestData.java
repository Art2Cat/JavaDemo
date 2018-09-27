package com.art2cat.dev.nio;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.nio
 *
 * @author art2c
 * @date 7/2/2018
 */
public class RenameTestData {
    
    @Test
    public void rename() {
        Path path = Paths
            .get("src", "test", "resources");
        try (Stream<Path> pathStream = Files.walk(path, 2, FileVisitOption.FOLLOW_LINKS)) {
            pathStream.filter(path1 -> path1.toString().endsWith(".csv"))
                .forEach(path1 -> {
                    String newFileName = path1.getParent().getFileName().toString() + "_"
                        + path1.getFileName().toString();
                    Path dest = Paths.get(path.toString(), newFileName.replace(" ", "_"));
                    System.out.println("dest: " + dest);
                    try {
                        Files.move(path1, dest);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
