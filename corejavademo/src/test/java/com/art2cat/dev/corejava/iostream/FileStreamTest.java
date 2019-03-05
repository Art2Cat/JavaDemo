package com.art2cat.dev.corejava.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileStreamTest {

    private Path path = Paths.get("src", "test", "resources", "out.dat");

    @Test
    public void testFileOutputStream() {
        try (FileOutputStream out = new FileOutputStream(path.toString())) {
            out.write('A');
            out.write('B');
            out.write("中国".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void testFileInputStream() {
        try (FileInputStream in = new FileInputStream(path.toString())) {
            byte[] buffer = new byte[1024];
            int c;
            StringBuilder builder = new StringBuilder();
            while ((c = in.read(buffer, 0, buffer.length)) != -1) {
                builder.append(new String(buffer, 0, c, StandardCharsets.UTF_8));
            }
            Assertions.assertEquals("AB中国", builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
