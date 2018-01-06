package com.art2cat.dev.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class JdbcTemplateTest extends ADatabaseTest {
    
    @Autowired
    private JdbcDataRepository jdbcDataRepository;
    
    @Before
    public void _init() {
        super._init();
        jdbcDataRepository.addOne(vendor);
    }
    
    @Test
    public void testFindOne() {
        Vendor one = jdbcDataRepository.findOne(12222L);
        assertNotNull(one);
        assertEquals(vendor.getName(), one.getName().trim());
        assertEquals(vendor.getCountry(), one.getCountry().trim());
        assertEquals(vendor.getAddress(), one.getAddress().trim());
    }
    
    @After
    public void end() {
        jdbcDataRepository.deleteOne(12222L);
    }
    
}
