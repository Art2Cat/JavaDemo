package com.art2cat.dev.corejava;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
        BigDecimal bd = new BigDecimal(origin);
        BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        Double result = Double.parseDouble(bd2.toString());
        System.out.println(result); // 123.37
    }
}
