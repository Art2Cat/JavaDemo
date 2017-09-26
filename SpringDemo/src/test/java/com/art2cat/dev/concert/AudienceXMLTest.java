package com.art2cat.dev.concert;

import com.art2cat.dev.concert.IPerformance;
import com.art2cat.dev.concert.xmlconfig.AudienceXML;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@RunWith(JUnit4.class)
public class AudienceXMLTest extends TestCase {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("concert/spring.xml");
        assertNotNull(ctx);
        AudienceXML audienceXML =  (AudienceXML) ctx.getBean("audienceXML");
        IPerformance performance = (IPerformance) ctx.getBean("performanceXML");
        performance.perform();
        audienceXML.setName("test");


        assertEquals("Clap Clap Clap!!!", audienceXML.getMessage("test", 2));

    }
}
