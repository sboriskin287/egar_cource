package com.company.core;

import com.company.core.entity.Hero;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Bank {

    private Map<Hero, Account> heroAccMap = new HashMap<>();

    public void addRecord(Hero hero, Account acc) {
        heroAccMap.put(hero, acc);
    }

    public Collection<Account> getAllAccounts() {
        return heroAccMap.values();
    }
}
