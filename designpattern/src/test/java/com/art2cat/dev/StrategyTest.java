package com.art2cat.dev;

import com.art2cat.dev.strategy.HandSign;
import com.art2cat.dev.strategy.Player;
import com.art2cat.dev.strategy.ProbStrategy;
import com.art2cat.dev.strategy.WinningStrategy;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/29/2018
 */
public class StrategyTest {

    @Test
    public void test() {
        Player player = new Player(new WinningStrategy(), "Taro");
        Player player1 = new Player(new ProbStrategy(), "Hana");
        for (int i = 0; i < 10000; i++) {
            HandSign handSign = player.nexHand();
            HandSign handSign1 = player1.nexHand();
            if (handSign.isStrongerThan(handSign1)) {
                System.out.println("Winner: " + player);
                player.win();
                player1.lose();
            } else if (handSign.isWeakerThan(handSign1)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player.lose();
            } else {
                System.out.println("Even...");
                player.even();
                player1.even();
            }
        }
        System.out.println("Total result: ");
        System.out.println(player);
        System.out.println(player1);
    }
}
