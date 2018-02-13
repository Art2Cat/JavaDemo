package com.art2cat.dev.springmvc.spittr.javaconfig;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet {
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
        throws ServletException, IOException {
        
    }
    
    @Override
    public String getServletInfo() {
        return null;
    }
    
    @Override
    public void destroy() {
    
    }
}
