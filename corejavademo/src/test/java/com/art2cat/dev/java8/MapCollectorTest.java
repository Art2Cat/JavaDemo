package com.art2cat.dev.java8;

import com.art2cat.dev.corejava.util.RandomUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapCollectorTest {

    private Map<String, Integer> source;

    @BeforeEach
    void init() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        source = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            source.put(RandomUtil.randomAlphaNumeric(4), random.nextInt(10));
        }
    }

    @Test
    void test() {
        source.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        var sortedMap = source.entrySet().stream()
            .sorted(Map.Entry.comparingByValue()).collect(
                Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1,
                    LinkedHashMap::new));

        System.out.println("sorted: ");
        sortedMap.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
