package com.company.context;

import com.company.domain.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ReplaceDeprecatedBeanFactoryPostProcessor
implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        Arrays
                .stream(bf.getBeanDefinitionNames())
                .map(bf::getBeanDefinition)
                .forEach(this::handleBeanDef);
    }

    private void handleBeanDef(BeanDefinition bd) {
        String beanClassName = bd.getBeanClassName();
        try {
            if (beanClassName == null) {
                return;
            }
            Class<?> aClass = Class.forName(beanClassName);
            DeprecatedClass dc = aClass.getAnnotation(DeprecatedClass.class);
            if (dc == null) {
                return;
            }
            Class<?> newClass = dc.newImpl();
            bd.setBeanClassName(newClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
