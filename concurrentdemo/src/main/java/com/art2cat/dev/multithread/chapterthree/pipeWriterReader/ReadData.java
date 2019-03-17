package com.art2cat.dev.multithread.chapterthree.pipeWriterReader;

import java.io.IOException;
import java.io.PipedReader;

/**
 * Created by Rorschach on 10/07/2017.
 */
class ReadData {

    void read(PipedReader reader) {
        try {
            System.out.println("Read: ");
            char[] chars = new char[20];
            int readLength = reader.read(chars);
            while (readLength != -1) {
                String newData = new String(chars, 0, readLength);
                System.out.print(newData);
                readLength = reader.read(chars);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
