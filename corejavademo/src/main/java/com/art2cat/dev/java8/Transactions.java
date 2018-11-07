package com.art2cat.dev;

import java.util.Arrays;
import java.util.List;

public class Transactions {
    
    public static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader test = new Trader("Test", "London");
        Trader test1 = new Trader("Test1", "London");
        Trader test2 = new Trader("Test2", "Paris");
        Trader test3 = new Trader("Test3", "Paris");
        return Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(alan, 2016, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(test, 2013, 950),
            new Transaction(test1, 2013, 880),
            new Transaction(test2, 2013, 350),
            new Transaction(test3, 2014, 677),
            new Transaction(test2, 2014, 974),
            new Transaction(test1, 2014, 1145)
        );
    }
}
