package com.art2cat.dev.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * com.art2cat.dev.nio
 *
 * @author art2c
 * @date 4/12/2018
 */
public class ChannelTest {
    
    @Test
    public void basicChannel() {
        Path path = Paths.get("src", "test", "resources", "text.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toString(), "rw")) {
            try (FileChannel inChannel = randomAccessFile.getChannel()) {
                ByteBuffer buffer = ByteBuffer.allocate(48);
                int byteReads = inChannel.read(buffer);
                for (; byteReads != -1; byteReads = inChannel.read(buffer)) {
                    System.out.println("Read " + byteReads);
                    buffer.flip();
                    
                    while (buffer.hasRemaining()) {
                        System.out.println((char) buffer.get());
                    }
                    buffer.clear();
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void transferFrom() {
        Path fromFile = Paths.get("src", "test", "resources", "text.txt");
        Path toFile = Paths.get("src", "test", "resources", "nio.txt");
        
        try (FileChannel fromChannel = FileChannel.open(fromFile)) {
            try (FileChannel toChannel = FileChannel.open(toFile)) {
                long position = 0;
                long count = fromChannel.size();
                toChannel.transferFrom(fromChannel, position, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void transferTo() {
        Path fromFile = Paths.get("src", "test", "resources", "text.txt");
        Path toFile = Paths.get("src", "test", "resources", "nio.txt");
        
        try (FileChannel fromChannel = FileChannel.open(fromFile)) {
            try (FileChannel toChannel = FileChannel.open(toFile)) {
                long position = 0;
                long count = fromChannel.size();
                fromChannel.transferTo(position, count, toChannel);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void testSocketChannel() {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            // Enable Non-blocking Mode.
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("www.google.com", 80));
            
            while (!socketChannel.finishConnect()) {
                if (socketChannel.isConnectionPending()) {
                    Thread.sleep(1000);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    
    }
    
}
