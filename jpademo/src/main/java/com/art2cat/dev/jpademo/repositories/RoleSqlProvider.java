package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.Role;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RoleSqlProvider {

    public String getRoleByName(String name) {
        SQL sql = new SQL().SELECT("id, role_name as roleName, create_date as createDate, note")
            .FROM("role");
        if (!StringUtils.isEmpty(name)) {
            sql.WHERE("role_name like concat('%',#{name},'%')");
        }
        return sql.toString();
    }

    public String save(Role role) {
        SQL sql = new SQL().INSERT_INTO("role")
            .INTO_COLUMNS("role_name", "create_date", "note")
            .INTO_VALUES("#{roleName}", "#{createDate}", "#{note}");
        return sql.toString();
    }

    public String update(Role role) {
        SQL sql = new SQL().UPDATE("role")
            .SET("role_name=#{roleName}, create_date=#{createDate}, note=#{note}")
            .WHERE("id=#{id}");
        return sql.toString();
    }
}
