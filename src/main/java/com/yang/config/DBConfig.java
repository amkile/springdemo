package com.yang.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * 数据源基础配置
 * @author ygl
 * @description
 * @date 2019/12/19
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class DBConfig {

    @Primary
    @Bean(name = "yangDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.yang") // 重定向DataSourceProperties的属性装配datasource->datasource.yang
    public DataSourceProperties yangDataSourceProperties() {
        log.debug("创建yangDataSourceProperties");
        return new DataSourceProperties();
    }


    @Primary
    @Bean(name = "yangDataSource")
    public DataSource yangDataSource(@Qualifier("yangDataSourceProperties") DataSourceProperties dataSourceProperties,DruidDataSource druidDataSource) throws CloneNotSupportedException {
        log.debug("创建yangDataSource");
        return setDataSource(dataSourceProperties,druidDataSource);
    }


    @Bean(name = "aprfundDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.aprfund")
    public DataSourceProperties aprfundDataSourceProperties() {
        log.debug("创建aprfundDataSourceProperties");
        return new DataSourceProperties();
    }



    @Bean("aprfundDataSource")
    public DataSource aprfundDataSource(@Qualifier("aprfundDataSourceProperties") DataSourceProperties dataSourceProperties,DruidDataSource druidDataSource) throws CloneNotSupportedException {
        log.debug("创建aprfundDataSource");
        return setDataSource(dataSourceProperties,druidDataSource);
    }

    @Primary
    @Bean(name = "yangManager")
    public PlatformTransactionManager yangManager(@Qualifier("yangDataSource") DataSource dataSource) {
        log.debug("创建yangManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "aprfundManager")
    public PlatformTransactionManager aprfundManager(@Qualifier("aprfundDataSource") DataSource dataSource) {
        log.debug("创建aprfundManager");
        return new DataSourceTransactionManager(dataSource);
    }

    private DataSource setDataSource( DataSourceProperties dataSourceProperties,DruidDataSource druidDataSource) throws CloneNotSupportedException {
        DruidDataSource local = (DruidDataSource) druidDataSource.clone();
        local.setUrl(dataSourceProperties.getUrl());
        local.setUsername(dataSourceProperties.getUsername());
        local.setPassword(dataSourceProperties.getPassword());
        local.setDriverClassName(dataSourceProperties.getDriverClassName());
        return local;
    }

}
