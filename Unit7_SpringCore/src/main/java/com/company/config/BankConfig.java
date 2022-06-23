package com.company.config;

import com.company.domain.Bank;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfig {

    @Bean
    public Bank bank() {
        return new Bank();
    }
}
