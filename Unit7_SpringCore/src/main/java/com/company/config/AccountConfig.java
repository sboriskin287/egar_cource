package com.company.config;

import com.company.domain.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AccountConfig {

    private static final String PROTO_SCOPE = "prototype";

    @Bean
    @Scope(PROTO_SCOPE)
    public Account account() {
        return new Account();
    }

    @Bean
    public AccountWrapper accountWraper() {
        return this::account;
    }
}
