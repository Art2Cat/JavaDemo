package com.art2cat.dev.multithread.chapterthree.pipeWriterReader;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by Rorschach on 10/07/2017.
 */
public class Run {

    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedReader inputStream = new PipedReader();
            PipedWriter outputStream = new PipedWriter();

            // same effective
            inputStream.connect(outputStream);
            // outputStream.connect(inputStream);

            Thread threadRead = new Thread(() -> readData.read(inputStream));
            threadRead.start();
            Thread.sleep(2000);

            Thread threadWrite = new Thread(() -> writeData.write(outputStream));
            threadWrite.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
