package com.art2cat.dev;

import com.art2cat.dev.memento.Gamer;
import com.art2cat.dev.memento.Memento;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 6/11/2018
 */
public class MementoTest {

    @Test
    public void test() {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();

        for (int i = 0; i < 100; i++) {
            System.out.println("=== " + i);
            System.out.println("current status: " + gamer);
            gamer.bet();
            System.out.println("money: " + gamer.getMoney());

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println(" gamer money exceed memento money, no need changes.");
            } else if (gamer.getMoney() < memento.getMoney()) {
                System.out.println("gamer money less than memento money, so store to memento.");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }

}
