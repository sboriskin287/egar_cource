package com.company.service;

import com.company.domain.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
//@EnableScheduling
@RequiredArgsConstructor
public class BankService {

    private final Bank bank;

    @Scheduled(cron = "*/15 * * * * *")
    public void calcNewAccAmount() {
        bank
                .getAllAccounts()
                .forEach(a -> {
                    BigDecimal oldVal = a.getAmount();
                    //a.applyRate();
                    BigDecimal newVal = a.getAmount().add(BigDecimal.valueOf(10));
                    System.out.printf("Account %s, " +
                            "old value %s, " +
                            "new value %s%n",
                            a.getNumber(),
                            oldVal.toString(),
                            newVal.toString());
                });
    }
}
