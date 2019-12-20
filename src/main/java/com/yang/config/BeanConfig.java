package com.yang.config;

import com.yang.entity.YangProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ygl
 * @description
 * @date 2019/12/20
 */
@Configuration
@Slf4j
public class BeanConfig {
    @Bean(name = "yangProperties")
    public YangProperties YangProperties(){
        return new YangProperties();
    }
}
