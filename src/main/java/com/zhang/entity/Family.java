package com.zhang.entity;

import com.zhang.utill.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "family")
@PropertySource(value = "classpath:test-family.yml",factory = MixPropertySourceFactory.class)
public class Family {
    private String name;
    private String sex;
}
