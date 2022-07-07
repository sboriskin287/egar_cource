package com.company.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = "classpath:domain.yaml")
@ConfigurationProperties(prefix = "bean.actual")
@Component
@Data
public class DomainProperty {
    private String message;
    private Integer number;
}
