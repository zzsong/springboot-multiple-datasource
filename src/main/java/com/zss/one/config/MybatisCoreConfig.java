package com.zss.one.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScans({
        @MapperScan(basePackages = "com.zss.one.mapper.core", sqlSessionTemplateRef = "coreSqlSessionTemplate",sqlSessionFactoryRef = "coreSqlSessionFactory"),
        @MapperScan(basePackages = "com.zss.one.mapper.schedule", sqlSessionTemplateRef = "scheduleSqlSessionTemplate",sqlSessionFactoryRef = "scheduleSqlSessionFactory")
})
public class MybatisCoreConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.core")
    public DataSource coreDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory coreSqlSessionFactory(@Qualifier("coreDataSource") DataSource coreDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(coreDataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate coreSqlSessionTemplate(@Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
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
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate scheduleSqlSessionTemplate(@Qualifier("scheduleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
