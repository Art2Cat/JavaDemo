package com.art2cat.dev.jpademo;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * com.art2cat.dev.jpademo
 *
 * @author rorschach
 * @date 3/25/18
 */
@Configuration
public class DataSourceConf {
    
    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306:test");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
    }
}
