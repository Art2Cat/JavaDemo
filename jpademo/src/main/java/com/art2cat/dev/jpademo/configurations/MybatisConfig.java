package com.art2cat.dev.jpademo.configurations;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

/**
 * com.art2cat.dev.jpademo.configurations
 *
 * @author rorschach
 * @date 4/15/18
 */
@Configuration
@Import(AppConfigs.class)
public class MybatisConfig {
    
    private static final String MAPPER_PACKAGE_NAME = "com.art2cat.dev.jpademo.mybatis.mapper";
    private static final String BASE_PACKAGE_NAME = "com.art2cat.dev.jpademo.repositories";
    
    @Autowired
    private AppConfigs appConfigs;
    
    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(true);
        configuration.setUseGeneratedKeys(true);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        configuration.setLazyLoadingEnabled(true);
        configuration.setDefaultStatementTimeout(25000);
        configuration.addMappers(MAPPER_PACKAGE_NAME);
        return configuration;
    }
    
    
    @Bean
    public Resource[] mappers() {
        Resource roleMapper = new ClassPathResource("mapper_role.xml");
        Resource userMapper = new ClassPathResource("mapper_user.xml");
        return new Resource[]{roleMapper, userMapper};
    }
    
    
    @Bean
    @Scope("prototype")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(appConfigs.dataSource());
        sqlSessionFactory.setMapperLocations(mappers());
        sqlSessionFactory.setConfiguration(configuration());
        return sqlSessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(appConfigs.dataSource());
    }
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage(BASE_PACKAGE_NAME);
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionTemplate");
        scannerConfigurer.setAnnotationClass(Repository.class);
        return scannerConfigurer;
    }
}
