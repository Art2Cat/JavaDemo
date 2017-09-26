package com.art2cat.dev.concert;

import com.art2cat.dev.concert.IPerformance;
import com.art2cat.dev.concert.javaconfig.Audience;
import com.art2cat.dev.concert.javaconfig.ConcertConfig;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class AudienceTest extends TestCase {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private Audience audience;


    @Autowired
    private IPerformance performance;

    @Test
    public void test() {
        performance.perform();
        audience.setName("test");

        assertEquals("Clap Clap Clap!!!", audience.getMessage("test", 2));

    }
}
