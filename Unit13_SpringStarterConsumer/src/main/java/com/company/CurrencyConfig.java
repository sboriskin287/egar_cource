package com.company;

import com.company.currency.Currency;
import com.company.currency.EurCurrency;
import com.company.currency.RubCurrency;
import com.company.currency.UsdCurrency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CurrencyConfig {
    @Bean
    public Currency rubbleCurrency() {
        return new RubCurrency() {
            @Override
            public String printName() {
                return "NEW RUB";
            }
        };
    }

    @Bean
    public Currency usdCurrency() {
        return new UsdCurrency() {
            @Override
            public String printName() {
                return "NEW USD";
            }
        };
    }

    @Bean
    public Currency eurCurrency() {
        return new EurCurrency() {
            @Override
            public String printName() {
                return "NEW EUR";
            }
        };
    }
}
