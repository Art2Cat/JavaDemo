package com.art2cat.dev.nio;

import java.nio.CharBuffer;

/**
 * com.art2cat.dev.nio
 *
 * @author rorschach
 * @date 4/1/18
 */
public class BufferFillDrain {

    private static int index = 0;
    private static String[] strings = {"A random string value",
        "The product of an infinite number of monkeys",
        "Hey hey we're the Monkees", "Opening act for the Monkees: Jimi Hendrix",
        "'Scuse me while I kiss this fly",
        "Help Me! Help Me!",};

    static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();
    }

    static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return (false);
        }
        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return (true);
    }
}

