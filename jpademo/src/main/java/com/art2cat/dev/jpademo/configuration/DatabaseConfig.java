package com.art2cat.dev.jpademo.configuration;

import com.art2cat.dev.jpademo.jdbc.JdbcTemplate;
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
public class DatabaseConfig {
    
    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(
            "jdbc:mysql://104.225.238.185:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);
    }
}
