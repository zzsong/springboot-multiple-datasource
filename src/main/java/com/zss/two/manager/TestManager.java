package com.zss.two.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestManager {

    @Autowired
    private TwoManager twoManager;

    @PostConstruct
    public void testQuery(){
        System.out.println("===使用注解配置数据源=====testQuery==========begin==========");
        twoManager.core();
        twoManager.schedule();

        System.out.println("========testQuery==========end==========");
    }


}
