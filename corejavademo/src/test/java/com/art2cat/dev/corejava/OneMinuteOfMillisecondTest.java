package com.art2cat.dev.corejava;

import java.time.LocalTime;
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
        System.out.println(LocalTime.now());
        try {
            Thread.sleep(6000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(LocalTime.now());
    }
}
