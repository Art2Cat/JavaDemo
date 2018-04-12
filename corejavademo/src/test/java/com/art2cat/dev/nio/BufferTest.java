package com.art2cat.dev.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * com.art2cat.dev.nio
 *
 * @author art2c
 * @date 4/12/2018
 */
public class BufferTest {
    
    @Test
    public void basicBuffer() {
        Path path = Paths.get("src", "test", "resources", "nio.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toString(), "rw")) {
            try (FileChannel inChannel = randomAccessFile.getChannel()) {
                //create buffer with capacity of 48 bytes
                ByteBuffer byteBuffer = ByteBuffer.allocate(48);
                byte[] inputs = "This is test String".getBytes();
                byteBuffer.put(inputs);
                byteBuffer.flip();
                while (!byteBuffer.hasRemaining()) {
                    inChannel.write(byteBuffer);
                }
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        
    }
}
