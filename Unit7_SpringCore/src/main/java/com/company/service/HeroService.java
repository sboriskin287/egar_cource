package com.company.service;

import com.company.config.AccountWrapper;
import com.company.core.Account;
import com.company.core.Bank;
import com.company.core.entity.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final Bank bank;
    private final AccountWrapper accWrapper;

    public void putOnDeposit(Hero hero) throws Exception {
        Account acc = accWrapper.get();
        acc.setAmount(hero.getCash());
        bank.addRecord(hero, acc);
    }

    public void printAllDeposit() {
        for (Map.Entry<Hero, Account> e
                : bank.getHeroAccMap().entrySet()) {
            System.out.printf("Hero id: %d Account: %s%n",
                    e.getKey().getId(), e.getValue().getNumber());
        }
    }
}
