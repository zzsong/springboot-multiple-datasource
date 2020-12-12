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
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource coreDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(coreDataSource);
        sessionFactory.getObject().getConfiguration().setJdbcTypeForNull(null);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer coreMapperScannerConfig(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setNameGenerator(slaveBeanNameGenerator); //不指定，使用默认
        configurer.setBasePackage("com.zss.third.mapper");
        configurer.setSqlSessionFactoryBeanName("masterSqlSessionFactory");
        configurer.setSqlSessionTemplateBeanName("masterSqlSessionTemplate");
        return configurer;
    }


    //======schedule========
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDateSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(slaveDateSource);
        sessionFactory.getObject().getConfiguration().setJdbcTypeForNull(null);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public MapperScannerConfigurer slaveMapperScannerConfig(SlaveBeanNameGenerator slaveBeanNameGenerator){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setNameGenerator(slaveBeanNameGenerator);
        configurer.setBasePackage("com.zss.third.mapper");
        configurer.setSqlSessionFactoryBeanName("slaveSqlSessionFactory");
        configurer.setSqlSessionTemplateBeanName("slaveSqlSessionTemplate");
        return configurer;
    }
}
