package com.company.currency.autoconfiguration;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(ConditionByLocale.class)
public @interface ConditionalOnLocale {

    String value();
}
