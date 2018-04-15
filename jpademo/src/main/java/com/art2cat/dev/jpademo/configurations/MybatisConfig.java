package com.art2cat.dev.jpademo.configurations;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

/**
 * com.art2cat.dev.jpademo.configurations
 *
 * @author rorschach
 * @date 4/15/18
 */
@Configuration
@Import(AppConfig.class)
public class MybatisConfig {
    
    @Autowired
    private AppConfig appConfig;
    
    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(true);
        configuration.setUseGeneratedKeys(true);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        configuration.setLazyLoadingEnabled(true);
        configuration.setDefaultStatementTimeout(25000);
        configuration.addMappers("com.art2cat.dev.jpademo.mybatis.mapper");
        return configuration;
    }
    
    @Bean
    @Scope("prototype")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(appConfig.dataSource());
        sqlSessionFactory.setConfiguration(configuration());
        return sqlSessionFactory;
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() {
        try {
            return new SqlSessionTemplate(sqlSessionFactory().getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(appConfig.dataSource());
    }
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.art2cat.dev.jpa");
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionTemplate");
        scannerConfigurer.setAnnotationClass(Repository.class);
        return scannerConfigurer;
    }
}
