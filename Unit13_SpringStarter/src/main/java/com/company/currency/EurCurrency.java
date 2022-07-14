package com.company.currency.autoconfiguration;

import java.math.BigDecimal;

public class EurCurrency implements Currency {
    @Override
    public String printName() {
        return "EUR";
    }

    @Override
    public BigDecimal courseByRubble() {
        return null;
    }
}
