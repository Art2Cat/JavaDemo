package com.art2cat.dev.concert.javaconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AroundAudience {

    @Pointcut("execution(* com.art2cat.dev.concert.IPerformance.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            joinPoint.proceed();
            System.out.println("Clap Clap Clap!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
