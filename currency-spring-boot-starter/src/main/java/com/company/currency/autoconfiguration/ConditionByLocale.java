package com.company.currency.autoconfiguration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

public class ConditionByLocale implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String prop = System.getProperty("user.country");
        MultiValueMap<String, Object> map =
                metadata.getAllAnnotationAttributes(ConditionalOnLocale.class.getName());
        List<Object> val = map.get("value");
        return prop.equals(val.get(0));
    }
}
