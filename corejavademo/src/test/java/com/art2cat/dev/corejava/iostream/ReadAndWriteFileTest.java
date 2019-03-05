package com.art2cat.dev.corejava.iostream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadAndWriteFileTest {

    private Path path = Paths.get("src", "test", "resources", "text.txt");

    @Test
    public void testBufferedReader() {
        File output = new File("output.txt");
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(path.toString())));
            PrintWriter pw = new PrintWriter("output.txt")) {
            if (!output.exists()) {
                output.createNewFile();
            }
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pw.println(line);
                pw.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void testFileReader() {
        try (FileReader reader = new FileReader(path.toString())) {
            char[] buffer = new char[2056];
            int c;
            while ((c = reader.read(buffer, 0, buffer.length)) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
