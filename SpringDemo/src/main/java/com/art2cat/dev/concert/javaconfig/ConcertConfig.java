package com.art2cat.dev.concert.javaconfig;


import com.art2cat.dev.concert.IPerformance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean AroundAudience aroundAudience() {
        return new AroundAudience();
    }

    @Bean
    public IPerformance performance() { return new Actor();
    }
}
