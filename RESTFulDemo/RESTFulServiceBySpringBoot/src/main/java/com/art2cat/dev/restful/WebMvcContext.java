package com.art2cat.dev.restful;

import com.art2cat.dev.restful.argumentresolver.impl.FileHolderArgumentHandler;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * com.art2cat.dev.restful
 *
 * @author Rorschach
 * @date 11/01/2018
 */
@Configuration
@EnableWebMvc
public class WebMvcContext extends WebMvcConfigurerAdapter {
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new FileHolderArgumentHandler());
    }
    
}
