package com.art2cat.dev.springmvc.spittr.javaconfig;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyFilterInitializer implements WebApplicationInitializer{


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic filter = servletContext.addFilter("myServlet", MyFilter.class);
        filter.addMappingForUrlPatterns(null, false,"/custom/**");
    }


}
