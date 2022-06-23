package com.company;

import com.company.domain.Account;
import com.company.domain.Bank;
import com.company.domain.Hero;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.company");
        Bank acc = ctx.getBean(Bank.class);
        System.out.println(acc);
    }
}
