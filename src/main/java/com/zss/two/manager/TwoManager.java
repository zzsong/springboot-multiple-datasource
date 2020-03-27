package com.zss.two.manager;

import com.alibaba.fastjson.JSON;
import com.zss.two.mapper.core.MemberMapper;
import com.zss.two.mapper.schedule.JobTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TwoManager {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private JobTaskMapper jobTaskMapper;

    @PostConstruct
    public void testQuery(){
        System.out.println("===使用注解配置数据源=====testQuery==========begin==========");
        System.out.println("==member=====>"+ JSON.toJSONString(memberMapper.queryById(1)));
        System.out.println("==========schedule库==========================");
        System.out.println("==member=====>"+ JSON.toJSONString(jobTaskMapper.queryById(1)));
        System.out.println("========testQuery==========end==========");
    }
}
