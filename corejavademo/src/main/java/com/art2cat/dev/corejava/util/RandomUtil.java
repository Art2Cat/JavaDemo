package com.art2cat.dev.corejava.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static String randomAlphaNumeric(int count) {

        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = random.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
