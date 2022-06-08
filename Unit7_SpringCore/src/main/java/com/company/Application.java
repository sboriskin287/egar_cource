package com.company;

import com.company.config.AccountWrapper;
import com.company.core.Account;
import com.company.core.Bank;
import com.company.core.entity.Hero;
import com.company.core.entity.Mage;
import com.company.service.HeroService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.company");

        HeroService service = ctx.getBean(HeroService.class);
        Hero h = new Hero();
        h.setId(287);
        h.setCash(BigDecimal.valueOf(100));
        service.putOnDeposit(h);
        service.printAllDeposit();

    }
}
