package com.zss.third.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisThirdConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.core")
    public DataSource coreDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory coreSqlSessionFactory(@Qualifier("coreDataSource") DataSource coreDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(coreDataSource);
        sessionFactory.getObject().getConfiguration().setJdbcTypeForNull(null);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate coreSqlSessionTemplate(@Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer coreMapperScannerConfig(CoreBeanNameGenerator coreBeanNameGenerator){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setNameGenerator(coreBeanNameGenerator);
        configurer.setBasePackage("com.zss.third.mapper.core,com.zss.third.mapper.order");
        configurer.setSqlSessionFactoryBeanName("coreSqlSessionFactory");
        configurer.setSqlSessionTemplateBeanName("coreSqlSessionTemplate");
        return configurer;
    }


    //======schedule========
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.schedule")
    public DataSource scheduleDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory scheduleSqlSessionFactory(@Qualifier("scheduleDataSource") DataSource coreDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(coreDataSource);
        sessionFactory.getObject().getConfiguration().setJdbcTypeForNull(null);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate scheduleSqlSessionTemplate(@Qualifier("scheduleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public MapperScannerConfigurer scheduleMapperScannerConfig(ScheduleBeanNameGenerator scheduleBeanNameGenerator){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setNameGenerator(scheduleBeanNameGenerator);
        configurer.setBasePackage("com.zss.third.mapper.schedule,com.zss.third.mapper.order");
        configurer.setSqlSessionFactoryBeanName("scheduleSqlSessionFactory");
        configurer.setSqlSessionTemplateBeanName("scheduleSqlSessionTemplate");
        return configurer;
    }
}
