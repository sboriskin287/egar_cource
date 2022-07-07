package com.company.context;

import com.company.domain.RandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class RandomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field f : bean.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(RandomInt.class)) {
                Random r = new Random();
                f.setAccessible(true);
                ReflectionUtils.setField(f, bean, r.nextInt());
                f.setAccessible(false);
            }
        }
        return bean;
    }
}
