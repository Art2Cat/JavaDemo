package com.art2cat.dev.restful.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqlTemplate {

    @Bean
    public String getCompanyByIdTemplate() {
        return "select * from company where id = :id";
    }

    @Bean
    public String addCompanyTemplate() {
        return "insert into company values(:id,:name,:address,:city,:state,:zipcode,:country)";
    }

    @Bean
    public String getCompanyByNameTemplate() {
        return "select * from company c where regexp_like (c.name , :name)";
    }

    @Bean
    public String getAllCompanyTemplate() {
        return "select * from company";
    }

    @Bean
    public String updateCompanyNameTemplate() {
        return "update company set name = :companyName where id = :id";
    }

    @Bean
    public String deleteCompanyTemplate() {
        return "delete from company where id = :id";
    }
}
