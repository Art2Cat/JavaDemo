package com.art2cat.dev.database;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class STJdbcTemplate extends NamedParameterJdbcTemplate {

    public STJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    private String getMaxValue(Object o) {
        if (o == null) {
            return "";
        }
        String s = o.toString();
        return s.substring(0, Math.min(s.length(), 4000));
    }
}
