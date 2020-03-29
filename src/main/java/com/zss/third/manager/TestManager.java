package com.zss.third.manager;

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
        System.out.println("================输出core数据库=============================");
        System.out.println("客户信息："+JSON.toJSONString(memberManager.queryMember(1)));
        System.out.println("订单信息："+JSON.toJSONString(memberManager.queryCoreOrder(1)));
        System.out.println("\n");
        System.out.println("================输出schedule数据库=============================");
        System.out.println("任务信息："+JSON.toJSONString(memberManager.queryJob(1)));
        System.out.println("订单信息："+JSON.toJSONString(memberManager.queryScheduleOrder(1)));
    }
}
