package com.company.domain;

import lombok.Data;

@Data
public class ActualBean implements TestDeprecatedBean {

    private String message;
    private Integer number;

    @Override
    public void print() {
        System.out.println(message);
        System.out.println(number);
    }
}
