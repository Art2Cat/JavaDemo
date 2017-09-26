package com.art2cat.dev.restful.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcTemplate extends NamedParameterJdbcTemplate {

    public JdbcTemplate(DataSource jdbcDataSource) {
        super(jdbcDataSource);
    }
}
