package com.company.config;

import com.company.core.Account;
import com.company.core.Archer;
import com.company.core.Hero;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BankConfig implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Bean
    public Map<Hero, Account> heroAccount() {
        Map<Hero, Account> m = new HashMap<>();
        return m;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
