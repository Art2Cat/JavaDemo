package com.art2cat.dev.cache.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.art2cat.dev.database.db")
@Import({DataConfig.class, CachingConfig.class})
public class RootConfig {

}
