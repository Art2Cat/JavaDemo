package com.art2cat.dev.corejava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class DoubleRoundingTest {

    private Double origin = 123.3666;

    @Test
    public void methodOne() {
        Double result = Math.round(origin * 100) / 100.0;
        System.out.println(result); // 123.37
    }

    @Test
    public void methodTwo() {
        DecimalFormat df = new DecimalFormat("#.##");
        Double result = Double.parseDouble(df.format(origin));
        System.out.println(result); // 123.37
    }

    @Test
    public void methodThree() {
        Double result = Double.parseDouble(String.format("%.2f", origin));
        System.out.println(result); // 123.37
    }

    @Test
    public void methodFour() {
        var bd = new BigDecimal(origin);
        var bd2 = bd.setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(bd2.doubleValue()); // 123.37
    }
}
