package com.art2cat.dev.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stringtemplate.v4.ST;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class STJdbcTemplateTest extends ADatabaseTest {
    
    @Autowired
    STJdbcTemplate stJdbcTemplate;
    private Logger logger = Logger.getLogger(STJdbcTemplateTest.class);
    private ApplicationContext context = new ClassPathXmlApplicationContext(
        "database/named_sql_template.xml");
    
    @Before
    public void _init() {
        super._init();
        String addVendorTemplate = (String) context.getBean("addVendorTemplate");
        ST st = new ST(addVendorTemplate);
        Map<String, Object> params = new HashMap<>();
        params.put("vendId", vendor.getId());
        params.put("name", vendor.getName());
        params.put("address", vendor.getAddress());
        params.put("city", vendor.getCity());
        params.put("state", vendor.getState());
        params.put("zip", vendor.getZip());
        params.put("country", vendor.getCountry());
        int result = stJdbcTemplate.update(st.render(), params);
        if (result != 0) {
            logger.info("Insert succeed!");
        } else {
            logger.warn("Insert failed!!!");
        }
        st = null;
    }
    
    @Test
    public void testFindOne() {
        ST st = new ST((String) context.getBean("findVendorTemplate"));
        Map<String, Object> params = new HashMap<>();
        params.put("vendId", vendor.getId());
        Vendor one = stJdbcTemplate.queryForObject(st.render(), params, (rs, rowNum) -> new Vendor(
            rs.getLong("VEND_ID"),
            rs.getString("VEND_NAME"),
            rs.getString("VEND_ADDRESS"),
            rs.getString("VEND_CITY"),
            rs.getString("VEND_STATE"),
            rs.getString("VEND_ZIP"),
            rs.getString("VEND_COUNTRY")));
        assertNotNull(one);
        assertEquals(vendor.getName(), one.getName().trim());
        assertEquals(vendor.getCountry(), one.getCountry().trim());
        assertEquals(vendor.getAddress(), one.getAddress().trim());
    }
}
