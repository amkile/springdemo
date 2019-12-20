package com.yang.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 连接池基础配置
 * @author ygl
 * @description
 * @date 2019/12/19
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidPropertiesWrapper extends DruidDataSource{
}
