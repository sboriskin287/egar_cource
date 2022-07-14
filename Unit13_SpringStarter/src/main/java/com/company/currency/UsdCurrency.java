package com.company.currency.autoconfiguration;

import java.math.BigDecimal;

public class UsdCurrency implements Currency {
    @Override
    public String printName() {
        return "USD";
    }

    @Override
    public BigDecimal courseByRubble() {
        return BigDecimal.valueOf(58, 3);
    }
}
