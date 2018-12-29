package com.art2cat.dev.java8;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LambdaTest {
    
    private List<String> strings;
    private List<User> users;
    
    private List<String> generateList() {
        List<String> strings = new ArrayList<>();
        Random random = new Random(10);
        for (int i = 0; i < 5; i++) {
            strings.add("String" + random.nextInt());
        }
        return strings;
    }
    
    private List<User> generateUserList() {
        List<User> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("user" + i);
            user.setPassword("password" + i);
            user.setAge(i * 2);
            strings.add(user);
        }
        return strings;
    }
    
    @BeforeEach
    public void init() {
        strings = generateList();
        users = generateUserList();
    }
    
    @Test
    public void testList() {
        strings.forEach(System.out::println);
        
        strings.sort((s1, s2) -> {
            int result = s1.compareTo(s2);
            System.out.println(result);
            return result;
        });
    }
    
    @Test
    public void testStream() {
        long startTime = System.currentTimeMillis();
        users.sort(Comparator.comparing(User::getAge));
        Map<String, List<User>> nusers = users.stream()
            .filter(user -> user.getAge() < 15)
            .collect(groupingBy(User::getUsername));
        
        nusers.forEach(
            (key, values) -> values.forEach((user) -> System.out.println(user.getUsername())));
        System.out.println(System.currentTimeMillis() - startTime);
    }
    
    @Test
    public void testStream1() {
        long startTime = System.currentTimeMillis();
        users.sort(Comparator.comparing(User::getAge));
        Set<User> nusers = users.parallelStream()
            .filter(user -> user.getAge() < 15)
            .collect(toSet());
        nusers.forEach((user) -> System.out.println(user.getUsername()));
        System.out.println(System.currentTimeMillis() - startTime);
    }
    
    @AfterEach
    public void clear() {
        strings.clear();
        users.clear();
    }
}
