package com.art2cat.dev.multi_thread.chapterThree.pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by Rorschach
 * on 10/07/2017.
 */
class WriteData {
    void write(PipedOutputStream out) {
        try {
            System.out.println("Write: ");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
