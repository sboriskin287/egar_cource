package com.company.domain;

import org.springframework.stereotype.Component;

@Component
//@DeprecatedClass(newImpl = ActualBean.class)
public class DeprecatedBean implements TestDeprecatedBean {
    @Override
    public void print() {
        System.out.println("It's deprecated bean");
    }
}
