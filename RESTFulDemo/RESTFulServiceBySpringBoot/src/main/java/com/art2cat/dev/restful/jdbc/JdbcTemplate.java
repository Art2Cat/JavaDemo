package com.art2cat.dev.restful.jdbc;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplate extends NamedParameterJdbcTemplate {

    public JdbcTemplate(DataSource jdbcDataSource) {
        super(jdbcDataSource);
    }
}
