package com.art2cat.dev.database;

import static org.junit.Assert.assertNotNull;

import com.art2cat.dev.database.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class HibernateTest extends ADatabaseTest {
    
    HibernateRepository hibernateRepository;
    @Autowired
    LocalSessionFactoryBean sessionFactory;
    private Logger logger = LoggerFactory.getLogger(HibernateTest.class);
    
    @Before
    public void init() {
        super._init();
        
        hibernateRepository = new HibernateRepository((SessionFactory) sessionFactory);
    }
    
    @Test
    public void testFindAll() {
        assertNotNull(hibernateRepository);
        Integer count = hibernateRepository.count();
        assertNotNull(count);
        logger.info("current database contains: " + count);
        
    }
    
    
}
