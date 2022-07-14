package com.company.currency;

import java.math.BigDecimal;

public class UsdCurrency implements Currency {
    @Override
    public String printName() {
        return "USD";
    }

    @Override
    public BigDecimal courseByRubble() {
        return new BigDecimal("58.03");
    }
}
