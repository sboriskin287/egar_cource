package com.company;

import com.company.service.HeroService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.company");

        HeroService service = ctx.getBean(HeroService.class);
    }
}
