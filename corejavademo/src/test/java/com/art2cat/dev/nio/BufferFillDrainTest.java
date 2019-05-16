package com.art2cat.dev.nio;

import java.nio.CharBuffer;
import org.junit.jupiter.api.Test;

public class BufferFillDrainTest {

    @Test
    void test() {
        CharBuffer buffer = CharBuffer.allocate(100);
        while (BufferFillDrain.fillBuffer(buffer)) {
            buffer.flip();
            BufferFillDrain.drainBuffer(buffer);
            buffer.clear();
        }
    }
}
