package com.art2cat.dev.corejava;

import java.time.Duration;
import java.time.LocalTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 08/01/2018
 */
public class OneMinuteOfMillisecondTest {

    @Test
    public void test() {
        var localTime = LocalTime.now();
        System.out.println(localTime);
        try {
            Thread.sleep(6000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Duration duration = Duration.between(localTime, LocalTime.now());
        Assertions.assertEquals(60, duration.getSeconds());
    }
}
