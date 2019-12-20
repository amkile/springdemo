package com.yang.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ygl
 * @description
 * @date 2019/12/18
 */

@Data
@ConfigurationProperties(prefix = "yang")
public class YangProperties {

    private String name;

    private String password;

    private String driver;


}
