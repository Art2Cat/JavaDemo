package com.art2cat.dev.jpademo.jdbc;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * com.art2cat.dev.jpademo.jdbc
 *
 * @author rorschach
 * @date 4/11/18
 */
@Component
public class JdbcTemplate extends NamedParameterJdbcTemplate {
    
    public JdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }
}
