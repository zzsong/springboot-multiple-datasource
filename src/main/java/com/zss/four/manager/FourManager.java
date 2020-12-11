package com.zss.four.manager;

import com.alibaba.fastjson.JSON;
import com.zss.four.config.DataSourceContextHolder;
import com.zss.four.mapper.core.FourMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FourManager {

    @Autowired
    private FourMemberMapper fourMemberMapper;

    public void core(String key){
        new DataSourceContextHolder(key);
        System.out.println("================================"+key);
        System.out.println("==member=====>"+ JSON.toJSONString(fourMemberMapper.queryById(1)));
    }


}
