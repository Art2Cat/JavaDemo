package com.art2cat.dev.concert.xmlconfig;

import org.aspectj.lang.ProceedingJoinPoint;


public class AroundAudienceXML {

    public void performance() {}


    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Around: Silencing cell phones");
            System.out.println("Around: Taking seats");
            joinPoint.proceed();
            System.out.println("Around: Clap Clap Clap!!!");
        } catch (Throwable e) {
            System.out.println("Around: Demanding a refund");
        }
    }
}
