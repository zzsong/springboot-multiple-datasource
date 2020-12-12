package com.zss.one.manager;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestManager {

    @Autowired
    private MemberManager memberManager;

    @PostConstruct
    public void init(){
        System.out.println("===使用MapperScans==============begin==========");
        System.out.println("================输出master数据库=============================");
        System.out.println("master:"+JSON.toJSONString(memberManager.queryMasterById(1)));
        System.out.println("\n");
        System.out.println("================输出slave数据库=============================");
        System.out.println("slave:"+JSON.toJSONString(memberManager.querySlaveById(1)));
        System.out.println("===使用MapperScans==============finish==========");
    }
}
