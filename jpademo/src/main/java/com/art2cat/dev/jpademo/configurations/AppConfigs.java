package com.art2cat.dev.jpademo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

/**
 * com.art2cat.dev.jpademo.configurations
 *
 * @author rorschach
 * @date 4/12/18
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.art2cat.dev.jpademo.repositories")
@PropertySource("classpath:mysql.properties")
public class AppConfigs {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @ConditionalOnProperty(
            name = "usemysql",
            havingValue = "dev")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(env.getProperty("mysql.url"));
        dataSource.setUsername(env.getProperty("mysql.username") != null
                ? env.getProperty("mysql.username") : "");
        dataSource.setPassword(env.getProperty("mysql.password") != null
                ? env.getProperty("mysql.password") : "");

        Properties properties = new Properties();
        properties.setProperty("maxActive", "50");
        properties.setProperty("maxIdle", "30");
        properties.setProperty("maxWait", "10000");
        dataSource.setConnectionProperties(properties);
        return dataSource;
    }

    @Bean
    @ConditionalOnBean(name = "jdbcTemplate")
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "jpaVendorAdapter")
    @ConditionalOnMissingBean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        return jpaVendorAdapter;
    }

    @Bean(name = "entityManagerFactory")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
        lemfb.setDataSource(dataSource);
        lemfb.setJpaVendorAdapter(jpaVendorAdapter);
        lemfb.setPackagesToScan("com.art2cat.dev.jpademo.models");
        return lemfb;
    }
    @Bean
    @ConditionalOnMissingBean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @ConditionalOnResource(resources = "classpath:mysql.properties")
    @Conditional(HibernateCondition.class)
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("mysql-hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("mysql-hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("mysql-hibernate.show_sql") != null ? env.getProperty("mysql-hibernate.show_sql") : "false");

        return hibernateProperties;
    }

    static class HibernateCondition extends SpringBootCondition {

        private static final String[] CLASS_NAMES = {"org.hibernate.ejb.HibernateEntityManager", "org.hibernate.jpa.HibernateEntityManager"};

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
            ConditionMessage.Builder message = ConditionMessage.forCondition("Hibernate");

            return Arrays.stream(CLASS_NAMES).filter(className -> ClassUtils.isPresent(className, context.getClassLoader())).map(className -> ConditionOutcome.match(message.found("class").items(ConditionMessage.Style.NORMAL, className))).findAny()
                    .orElseGet(() -> ConditionOutcome.noMatch(message.didNotFind("class", "classes").items(ConditionMessage.Style.NORMAL, Arrays.asList(CLASS_NAMES))));
        }

    }
}
