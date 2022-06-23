package com.company.domain;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("heroBank")
@Getter
public class Bank {
    private Account acc;

    private Map<Hero, Account> heroAcc;

    public Bank(@Qualifier("accountProto2") Account acc, Map<Hero, Account> heroAcc) {
        this.acc = acc;
        this.heroAcc = heroAcc;
    }
}
