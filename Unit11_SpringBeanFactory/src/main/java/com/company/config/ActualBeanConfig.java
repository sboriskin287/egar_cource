package com.company.config;

import com.company.domain.ActualBean;
import com.company.domain.TestDeprecatedBean;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:domain.yaml", factory = YamlPropertyFactory.class)
public class ActualBeanConfig {

    //@Bean
    //@ConfigurationProperties(prefix = "bean.actual")
    public TestDeprecatedBean actualBean() {
        return new ActualBean();
    }
}
