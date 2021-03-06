package com.zss.two.manager;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestManager {

    @Autowired
    private TwoManager twoManager;

    @PostConstruct
    public void testQuery(){
        System.out.println("===使用注解配置数据源==============begin==========");
        System.out.println("================输出master数据库=============================");
        System.out.println("master:"+ JSON.toJSONString(twoManager.queryMasterById(1)));
        System.out.println("\n");
        System.out.println("================输出slave数据库=============================");
        System.out.println("slave:"+JSON.toJSONString(twoManager.querySlaveById(1)));
        System.out.println("===使用注解配置数据源==============finish==========");
    }


}
