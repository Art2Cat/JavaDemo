package com.art2cat.dev.maindemo;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.apache.ibatis.type.LocalDateTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

public class MybatisPlusConfig {

    /***
     * plus 的性能优化
     *
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
        performanceInterceptor.setMaxTime(5000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * @Description : mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    /**
     * 逻辑删除
     *
     * @return
     */
	/*@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}*/

    /**
     * 乐观锁
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
//
//    @Bean(name = "factory")
//    public SqlSessionFactory sqlSessionFactory1(DataSource dataSource1) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setTypeHandlers(
//                new TypeHandler[]{new LocalDateTimeTypeHandler(), new LocalDateTypeHandler()});
//        sqlSessionFactoryBean.setDataSource(dataSource1);
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
//        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
//        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
//        return sqlSessionFactory;
//    }
//
//    @Bean("factory1")
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean diSqlSessionFactoryBean = new SqlSessionFactoryBean();
//        diSqlSessionFactoryBean.setTypeHandlers(
//                new TypeHandler[]{new LocalDateTimeTypeHandler(), new LocalDateTypeHandler()});
//        diSqlSessionFactoryBean.setDataSource(dataSource);
//        SqlSessionFactory sqlSessionFactory = diSqlSessionFactoryBean.getObject();
//        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
//        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
//        return sqlSessionFactory;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer1() {
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setBasePackage(MAPPERS_PACKAGE_NAME_1);
//        configurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY_NAME_1);
//        return configurer;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer2() {
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setBasePackage(MAPPERS_PACKAGE_NAME_2);
//        configurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY_NAME_2);
//        return configurer;
//    }

}

