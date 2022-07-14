package com.company.currency;

import java.math.BigDecimal;

public class EurCurrency implements Currency {
    @Override
    public String printName() {
        return "EUR";
    }

    @Override
    public BigDecimal courseByRubble() {
        return new BigDecimal("58.84");
    }
}
