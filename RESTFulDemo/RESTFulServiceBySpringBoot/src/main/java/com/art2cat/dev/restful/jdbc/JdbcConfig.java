package com.art2cat.dev.restful.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.art2cat.dev.restful.jdbc")
public class JdbcConfig {

    @Bean
    public DataSource jdbcDataSource() {
	    DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@192.168.0.46:1521:db11g");
        ds.setUsername("mc_47_tll");
        ds.setPassword("slm123");
        return ds;
    }

    @Bean
    public JdbcTemplate stJdbcTemplate(DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);
    }
}
