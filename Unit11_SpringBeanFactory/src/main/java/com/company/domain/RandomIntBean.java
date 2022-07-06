package com.company.domain;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Component
@Data
public class RandomIntBean {

    @RandomInt
    private int number;

    @PostConstruct
    public void init() {
        System.out.println(number);
        System.out.println("Post construct");
    }
}
