package com.art2cat.dev.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * com.art2cat.dev.nio
 *
 * @author art2c
 * @date 4/12/2018
 */
public class ChannelTest {
    
    private Path fromFile = Paths.get("src", "test", "resources", "text.txt");
    private Path toFile = Paths.get("src", "test", "resources", "nio.txt");
    
    @Test
    public void basicChannel() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fromFile.toString(), "rw");
            FileChannel inChannel = randomAccessFile.getChannel()) {
            
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
            
        } catch (java.io.IOException e) {
            Assertions.fail(e.getMessage());
        }
    }
    
    @Test
    public void transferFrom() {
        
        try (FileChannel fromChannel = FileChannel.open(fromFile, StandardOpenOption.READ);
            FileChannel toChannel = FileChannel.open(toFile, StandardOpenOption.WRITE)) {
            long position = 0;
            long count = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, count);
            
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }
    
    @Test
    public void transferTo() {
        
        try (FileChannel fromChannel = FileChannel.open(fromFile, StandardOpenOption.READ);
            FileChannel toChannel = FileChannel.open(toFile, StandardOpenOption.WRITE)) {
            long position = 0;
            long count = fromChannel.size();
            fromChannel.transferTo(position, count, toChannel);
            
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }
    
    @Test
    public void testSocketChannel() {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            // Enable Non-blocking Mode.
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("www.bing.com", 80));
            
            while (!socketChannel.finishConnect()) {
                if (socketChannel.isConnectionPending()) {
                    Thread.sleep(1000);
                }
            }
        } catch (IOException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        
    }
    
}
