package com.art2cat.dev;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class TransactionsTest {
    
    private List<Transaction> transactions = Transactions.getTransactions();
    
    @Test
    public void testDeal() {
        List<Transaction> tr2011 = transactions.stream()
            .filter(transaction -> transaction.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
        
        tr2011.forEach(transaction -> System.out.println(transaction.getTrader().getName()));
        
        List<String> cites = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .distinct()
            .collect(Collectors.toList());
        Set<String> cites1 = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .collect(Collectors.toSet());
        
        cites.forEach(s -> cites1.forEach(s1 -> System.out.println(s + " : " + s1)));
    }
    
    @Test
    public void testFindCambridge() {
        List<Trader> traders = transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());
        
        String trader = traders.stream()
            .map(Trader::getName)
            .distinct().sorted()
            .collect(joining());
        
        System.out.println(trader);
        
        boolean milanBased = transactions.stream()
            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        
        assertTrue(milanBased);
        
        transactions.stream()
            .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
            .map(Transaction::getValue)
            .forEach(System.out::println);
        
        Optional<Integer> highestValue = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max);
        
        Assert.assertTrue(highestValue.isPresent());
        System.out.println(highestValue.get());
        
        Integer sumValue = transactions.stream()
            .mapToInt(Transaction::getValue)
            .sum();
        
        System.out.println(sumValue);
    }
    
    @Test
    public void testValueStream() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        
        Stream<String> emptyStream = Stream.empty();
    }
    
    @Test
    public void testFileStream() {
        long uniqueWords;
        try (Stream<String> lines = Files
            .lines(Paths.get("src", "test", "resource", "text.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void testFileStream1() {
        try (Stream<String> lines = Files
            .lines(Paths.get("src", "test", "resource", "text.txt"), Charset.defaultCharset())) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }
    
    @Test
    public void testListJavaContent() {
        try (Stream<Path> files = Files.walk(Paths.get("."))
            .filter((path -> path.toString().endsWith(".java")))) {
            files.forEach(path -> {
                try {
                    Files.lines(path, Charset.defaultCharset()).forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void testGenerate() {
        Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);
    }
}
