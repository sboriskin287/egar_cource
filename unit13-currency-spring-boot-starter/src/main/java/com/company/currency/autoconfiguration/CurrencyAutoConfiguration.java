package com.company.currency.autoconfiguration;

import com.company.currency.Currency;
import com.company.currency.EurCurrency;
import com.company.currency.RubCurrency;
import com.company.currency.UsdCurrency;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Currency rubbleCurrency() {
        return new RubCurrency();
    }

    @Bean
    @ConditionalOnMissingBean
    public Currency usdCurrency() {
        return new UsdCurrency();
    }

    @Bean
    @ConditionalOnMissingBean
    public Currency eurCurrency() {
        return new EurCurrency();
    }
}
