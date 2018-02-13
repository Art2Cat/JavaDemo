package com.art2cat.dev.multi_thread.chapterThree.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by Rorschach on 10/07/2017.
 */
class ReadData {

    void read(PipedInputStream in) {
        try {
            System.out.println("Read: ");
            byte[] bytes = new byte[20];
            int readLength = in.read(bytes);
            while (readLength != -1) {
                String newData = new String(bytes, 0, readLength);
                System.out.print(newData);
                readLength = in.read(bytes);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
