package com.art2cat.dev.multi_thread.chapterThree.pipeWriterReader;

import java.io.*;

/**
 * Created by Rorschach
 * on 10/07/2017.
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
