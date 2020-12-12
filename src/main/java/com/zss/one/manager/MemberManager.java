package com.zss.one.manager;

import com.zss.domain.Member;
import com.zss.one.mapper.master.OneMasterMemberMapper;
import com.zss.one.mapper.slave.OneSlaveMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberManager {

    @Autowired
    private OneMasterMemberMapper oneMasterMemberMapper;

    @Autowired
    private OneSlaveMemberMapper oneSlaveMemberMapper;

    public Member queryMasterById(long id){
        return oneMasterMemberMapper.queryById(id);
    }

    public Member querySlaveById(long id){
        return oneSlaveMemberMapper.queryById(id);
    }
}
