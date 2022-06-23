package com.company.config;

import com.company.domain.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    public Account accountProto1() {
        return new Account(1);
    }

    @Bean
    public Account accountProto2() {
        return new Account(2);
    }
}
