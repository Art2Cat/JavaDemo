package com.art2cat.dev.concert.javaconfig;


import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
    
    private Map<String, List<String>> audience = new HashMap<>();
    private List<String> list = Lists.newArrayList();
    private String name;
    
    public List<String> getAudience(String name) {
        return audience.getOrDefault(name, list);
    }

    public String getMessage(String name, int num) {
        return getAudience(name).isEmpty() ? "empty" : getAudience(name).get(num);
    }
    
    public void setAudience(Map<String, List<String>> audience) {
        this.audience = audience;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Pointcut("execution(* com.art2cat.dev.concert.IPerformance.perform(..))")
    public void performance() {
    }
    
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
        list.add("Silencing cell phones");
    }
    
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
        list.add("Taking seats");
    }
    
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("Clap Clap Clap!!!");
        list.add("Clap Clap Clap!!!");
        audience.put(name, list);
    }
    
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
        list.add("Demanding a refund");
        audience.put(name, list);
    }
    
    
}
