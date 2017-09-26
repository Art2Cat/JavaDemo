package com.art2cat.dev.database;

import com.art2cat.dev.database.hibernate.HibernateRepository;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import static org.junit.Assert.assertNotNull;

public class HibernateTest extends ADatabaseTest {

    private Logger logger = Logger.getLogger(HibernateTest.class);

    HibernateRepository hibernateRepository;
    @Autowired
    LocalSessionFactoryBean sessionFactory;

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
