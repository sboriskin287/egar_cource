package com.company.currency;

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
