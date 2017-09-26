package com.art2cat.dev.multi_thread.chapterThree.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Rorschach
 * on 10/07/2017.
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            // same effective
            inputStream.connect(outputStream);
            //outputStream.connect(inputStream);

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
