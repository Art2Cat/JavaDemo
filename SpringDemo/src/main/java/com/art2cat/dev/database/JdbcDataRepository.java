package com.art2cat.dev.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Types;
import java.util.logging.Logger;

@Component
public class JdbcDataRepository {

    private Logger logger = Logger.getLogger("JdbcDataRepository");
    private JdbcTemplate jdbcTemplate;

    private ApplicationContext context = new ClassPathXmlApplicationContext("database/sql_template.xml");

    public JdbcDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addOne(Vendor vendor) {
        SqlParameterValue id = new SqlParameterValue(Types.INTEGER, vendor.getId());
        SqlParameterValue name = new SqlParameterValue(Types.VARCHAR, vendor.getName());
        SqlParameterValue address = new SqlParameterValue(Types.VARCHAR, vendor.getAddress());
        SqlParameterValue city = new SqlParameterValue(Types.VARCHAR, vendor.getCity());
        SqlParameterValue state = new SqlParameterValue(Types.VARCHAR, vendor.getState());
        SqlParameterValue zip = new SqlParameterValue(Types.VARCHAR, vendor.getZip());
        SqlParameterValue country = new SqlParameterValue(Types.VARCHAR, vendor.getCountry());
        String addVendorTemplate = (String) context.getBean("addVendorTemplate");
        int result = jdbcTemplate.update(addVendorTemplate, id, name, address, city, state, zip, country);
        logger.info("result :" + result);
    }

    public Vendor findOne(Long vend_id) {
        String findVendorTemplate = (String) context.getBean("findVendorTemplate");
        SqlParameterValue id = new SqlParameterValue(Types.INTEGER, vend_id);
        logger.info("parameter :" + vend_id);
        return jdbcTemplate.queryForObject(findVendorTemplate, (rs, rowNum) -> new Vendor(
                rs.getLong("VEND_ID"),
                rs.getString("VEND_NAME"),
                rs.getString("VEND_ADDRESS"),
                rs.getString("VEND_CITY"),
                rs.getString("VEND_STATE"),
                rs.getString("VEND_ZIP"),
                rs.getString("VEND_COUNTRY")), id);
    }

    public void deleteOne(Long vend_id) {
        String deleteVendorTemplate = (String) context.getBean("deleteVendorTemplate");
        SqlParameterValue id = new SqlParameterValue(Types.INTEGER, vend_id);
        logger.info("parameter :" + vend_id);
        int result = jdbcTemplate.update(deleteVendorTemplate, id);
        logger.info("result :" + result);
    }
}
