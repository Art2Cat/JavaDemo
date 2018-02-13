package com.art2cat.dev.multi_thread.chapterThree.pipeWriterReader;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * Created by Rorschach on 10/07/2017.
 */
class WriteData {

    void write(PipedWriter writer) {
        try {
            System.out.println("Write: ");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                writer.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
