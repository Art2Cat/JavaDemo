package com.art2cat.dev.cache.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public EhCacheCacheManager ehCacheManager(CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheFactoryBean =
            new EhCacheManagerFactoryBean();
        ehCacheFactoryBean.setConfigLocation(
            new ClassPathResource("/ehcache.xml")
        );
        return ehCacheFactoryBean;
    }
}
