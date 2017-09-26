package com.art2cat.dev.cache;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class ErrorCacheMangerTest extends TestCase {
    private ErrorCacheManager cacheManager;
    private static final String ERROR_NAME = "error name test";

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("cache/spring.xml");
        cacheManager = (ErrorCacheManager) ctx.getBean("errorCacheManager");
    }

    @Test
    public void test() {

        System.out.println(cacheManager.hashCode());
        ErrorEntity errorEntity = cacheManager.get(ERROR_NAME);
        ErrorEntity errorEntity1 = cacheManager.get(ERROR_NAME);
        ErrorEntity errorEntity2 = cacheManager.get(ERROR_NAME);
        ErrorEntity errorEntity3 = cacheManager.get(ERROR_NAME);
        assertEquals(errorEntity, errorEntity1);
        assertEquals(errorEntity, errorEntity2);
        assertEquals(errorEntity, errorEntity3);

        assertEquals("error name test", errorEntity3.getName());
        System.out.println("name: " + errorEntity2.getName());
    }
}
