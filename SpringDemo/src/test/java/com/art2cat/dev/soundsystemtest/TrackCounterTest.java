package com.art2cat.dev.soundsystemtest;

import static org.junit.Assert.assertEquals;

import com.art2cat.dev.soundsystem.CompactDisc;
import com.art2cat.dev.soundsystem.TrackCounter;
import com.art2cat.dev.soundsystem.TrackCounterConfig;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Autowired
    private CompactDisc cd;
    
    @Autowired
    private TrackCounter counter;
    
    @Before
    public void init() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);
    }
    
    @Test
    public void testTrackCounter() {
        
        assertEquals(1, counter.getPlayCount(1));
        assertEquals(1, counter.getPlayCount(2));
        assertEquals(4, counter.getPlayCount(3));
        assertEquals(0, counter.getPlayCount(4));
        assertEquals(0, counter.getPlayCount(5));
        assertEquals(0, counter.getPlayCount(6));
        assertEquals(2, counter.getPlayCount(7));
        assertEquals(0, counter.getPlayCount(10));
        
    }
    
}
