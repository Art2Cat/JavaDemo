package com.art2cat.dev.corejava.iostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataStreamTest {

    private Path path = Paths.get("src", "test", "resources", "dos.dat");


    @Test
    public void testDataOutputStream() {
        File file = path.toFile();
        if (file.exists()) {
            file.delete();
        }
        String filePath = path.toString();
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(10);
            dos.writeInt(-10);
            dos.writeLong(10L);
            dos.writeDouble(10.5);
            // utf-8
            dos.writeUTF("中国");
            // utf-16be
            dos.writeChars("日本");
            IOUtil.printHex(filePath);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void testDataInputStream() {

        String file = path.toString();
        try (DataInputStream dis = new DataInputStream(
            new FileInputStream(file))) {
            IOUtil.printHex(file);
            int i = dis.readInt();
            Assertions.assertEquals(10, i);
            i = dis.readInt();
            Assertions.assertEquals(-10, i);
            long l = dis.readLong();
            Assertions.assertEquals(10L, l);
            double d = dis.readDouble();
            Assertions.assertEquals(10.5, d);
            String s = dis.readUTF();
            Assertions.assertEquals("中国", s);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
