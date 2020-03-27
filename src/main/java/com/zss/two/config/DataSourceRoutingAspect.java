package com.zss.two.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceRoutingAspect {
    @Around("@annotation(targetDataSource)")
    public Object routingWithDataSource(ProceedingJoinPoint joinPoint, TargetDataSource targetDataSource) throws Throwable {
        String key = targetDataSource.value();
        try (DynamicDataSource ds = new DynamicDataSource(key)) {
            return joinPoint.proceed();
        }
    }
}
