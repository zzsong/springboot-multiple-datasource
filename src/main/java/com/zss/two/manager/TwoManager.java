package com.zss.two.manager;

import com.zss.domain.Member;
import com.zss.two.config.DataSourceConstants;
import com.zss.two.config.TargetDataSource;
import com.zss.two.mapper.master.TwoMasterMemberMapper;
import com.zss.two.mapper.slave.TwoSlaveMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwoManager {

    @Autowired
    private TwoMasterMemberMapper twoMasterMemberMapper;

    @Autowired
    private TwoSlaveMemberMapper twoSlaveMemberMapper;


    @TargetDataSource(DataSourceConstants.MASTER_DATA_SOURCE)
    public Member queryMasterById(long id){
        return twoMasterMemberMapper.queryById(id);
    }

    @TargetDataSource(DataSourceConstants.SLAVE_DATA_SOURCE)
    public Member querySlaveById(long id){
        return twoSlaveMemberMapper.queryById(id);
    }
}
