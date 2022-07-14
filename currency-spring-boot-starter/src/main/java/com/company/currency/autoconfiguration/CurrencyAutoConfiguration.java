package com.company.currency.autoconfiguration;

import com.company.currency.Currency;
import com.company.currency.EurCurrency;
import com.company.currency.RubCurrency;
import com.company.currency.UsdCurrency;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
public class CurrencyAutoConfiguration {

    @Bean
    @ConditionalOnLocale("RU")
    public Currency rubbleCurrency() {
        return new RubCurrency();
    }

    @Bean
    @ConditionalOnLocale("US")
    public Currency usdCurrency() {
        return new UsdCurrency();
    }

    @Bean
    @ConditionalOnLocale("EU")
    public Currency eurCurrency() {
        return new EurCurrency();
    }
}
