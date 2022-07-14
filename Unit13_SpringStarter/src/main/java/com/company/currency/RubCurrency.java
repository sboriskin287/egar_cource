package com.company.currency.autoconfiguration;

import java.math.BigDecimal;

public class RubCurrency implements Currency {
    @Override
    public String printName() {
        return "RUB";
    }

    @Override
    public BigDecimal courseByRubble() {
        return BigDecimal.ONE;
    }
}
