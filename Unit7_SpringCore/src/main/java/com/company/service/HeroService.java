package com.company.service;

import com.company.config.AccountWrapper;
import com.company.domain.Account;
import com.company.domain.Bank;
import com.company.domain.entity.Hero;
import com.company.repo.HeroRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final Bank bank;
    private final AccountWrapper accWrapper;
    private final HeroRepo heroRepo;

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

    public List<Hero> findAllHero() {
        return heroRepo.findAll();
    }
}
