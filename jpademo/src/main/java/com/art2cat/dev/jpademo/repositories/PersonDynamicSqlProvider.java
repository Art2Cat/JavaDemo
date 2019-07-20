package com.art2cat.dev.jpademo.repositories;

import org.apache.ibatis.jdbc.SQL;

public class PersonDynamicSqlProvider {

    public String getPersonByName(String name) {
        return new SQL().SELECT("*").FROM("person").
            WHERE("name like #{name} || '%'").toString();
    }

}
