package com.zss.four.manager;

import com.zss.four.config.DataSourceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestManager {

    @Autowired
    private FourManager fourManager;

    @PostConstruct
    public void testQuery(){
        System.out.println("===使用注解配置数据源=====testQuery==========begin==========");

        fourManager.core(DataSourceConstants.MASTER_DATA_SOURCE);
        System.out.println(">>>>>>>>>>>>切换数据源>>>>>>>>>>>");

        fourManager.core(DataSourceConstants.SLAVE_DATA_SOURCE);

        System.out.println("========testQuery==========end==========");
    }


}
