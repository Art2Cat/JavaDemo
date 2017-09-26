package com.art2cat.dev.database;

import com.art2cat.dev.database.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.art2cat.dev.database")
public class DatabaseConfig {
//    @Bean
//    public JndiObjectFactoryBean dataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/test");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return jndiObjectFactoryBean;
//    }

    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@192.168.99.100:49161:xe");
        ds.setUsername("system");
        ds.setPassword("oracle");
        return ds;
    }

//    @Bean
//    public DataSource qaDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
//    }

//    @Bean
//    public BasicDataSource devDataSource() {
//        BasicDataSource ds = new BasicDataSource();
//        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        ds.setUrl("jdbc:oracle:thin:@192.168.99.100:49161:XE");
//        ds.setUsername("system");
//        ds.setPassword("oracle");
//        ds.setInitialSize(5);
//        ds.setMaxActive(10);
//        return ds;
//    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);
    }

    @Bean
    public JdbcDataRepository jdbcDataRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcDataRepository(jdbcTemplate);
    }

    @Bean
    public STJdbcTemplate stJdbcTemplate(DataSource jdbcDataSource) {
        return new STJdbcTemplate(jdbcDataSource);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean lfb = new LocalSessionFactoryBean();
        lfb.setDataSource(dataSource);
        lfb.setPackagesToScan("com.art2cat.dev.database");
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.ORACLEDialect");
        lfb.setHibernateProperties(properties);
        return lfb;
    }

    @Bean
    public HibernateRepository hibernateRepository(SessionFactory sessionFactory) {
        return new HibernateRepository(sessionFactory);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.ORACLE);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.ORACLEDialect");
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource
    , JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lcef = new LocalContainerEntityManagerFactoryBean();
        lcef.setDataSource(dataSource);
        lcef.setJpaVendorAdapter(jpaVendorAdapter);
        lcef.setPackagesToScan("com.art2cat.dev.database");
        return lcef;
    }

    @Bean
    public JndiObjectFactoryBean entityManagerFactory() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/VendorDS");
        return jndiObjectFactoryBean;
    }
}
