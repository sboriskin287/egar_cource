package com.company.domain;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestProfilerBeanImpl implements TestProfilerBean {

    @SneakyThrows
    @Profiler
    @Override
    public void doSomething() {
        System.out.println("Начало выполнения");
        Thread.sleep(500);
        System.out.println("Конец выполнения");
    }

    @PostConstruct
    public void init() {
        System.out.println("PC");
    }
}
