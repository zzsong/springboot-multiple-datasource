package com.zss.two.manager;

import com.alibaba.fastjson.JSON;
import com.zss.two.config.DataSourceConstants;
import com.zss.two.config.TargetDataSource;
import com.zss.two.mapper.core.TwoMemberMapper;
import com.zss.two.mapper.schedule.TwoJobTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwoManager {

    @Autowired
    private TwoMemberMapper twoMemberMapper;

    @Autowired
    private TwoJobTaskMapper twoJobTaskMapper;


    @TargetDataSource(DataSourceConstants.CORE_DATA_SOURCE)
    public void core(){
        System.out.println("==========core库==========================");
        System.out.println("==member=====>"+ JSON.toJSONString(twoMemberMapper.queryById(1)));
    }


    @TargetDataSource(DataSourceConstants.SCHEDULE_DATA_SOURCE)
    public void schedule(){
        System.out.println("==========schedule库==========================");
        System.out.println("==schedule=====>"+ JSON.toJSONString(twoJobTaskMapper.queryById(1)));
    }
}
