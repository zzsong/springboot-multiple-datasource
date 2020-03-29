package com.zss.third.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class ScheduleBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return "schedule"+ ClassUtils.getShortName(definition.getBeanClassName());
    }
}
