package com.company.context;

import com.company.domain.Profiler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
public class MethodProfilerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        boolean isNeedProxy = Arrays
                .stream(aClass.getDeclaredMethods())
                .anyMatch(m -> m.isAnnotationPresent(Profiler.class));
        if (!isNeedProxy) {
            return bean;
        }
        return Proxy.newProxyInstance(
                aClass.getClassLoader(),
                aClass.getInterfaces(),
                (proxy, method, args) -> {
                    if (!aClass.getDeclaredMethod(method.getName()).isAnnotationPresent(Profiler.class)) {
                        return method.invoke(bean, args);
                    }
                    Long startTime = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    Long endTime = System.nanoTime();
                    System.out.printf("Метод выполнялся %d наносекунд", endTime - startTime);
                    return retVal;
                });
    }
}
