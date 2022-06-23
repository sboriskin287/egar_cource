package com.company.domain;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Account {
    private static final BigDecimal FIFTEEN_SEC_RATE
            = BigDecimal.valueOf(24 * 60 * 4);

    private String number;
    private BigDecimal amount;
    private BigDecimal dailyRate = BigDecimal.valueOf(50);

    @PostConstruct
    public void genNumber() {
        number = UUID.randomUUID().toString();
    }

    public void applyRate() {
        BigDecimal minutePart = dailyRate.divide(FIFTEEN_SEC_RATE);
        BigDecimal delta = amount.multiply(minutePart);
        amount.add(delta);
    }
}
