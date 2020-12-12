package com.zss.third.manager;

import com.zss.domain.Member;
import com.zss.third.mapper.member.ThirdMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MemberManager {

    @Autowired
    @Qualifier("thirdMemberMapper")
    private ThirdMemberMapper thirdMemberMapper;

    @Autowired
    @Qualifier("slaveThirdMemberMapper")
    private ThirdMemberMapper slaveThirdMemberMapper;


    public Member queryMasterById(long id){
        return thirdMemberMapper.queryById(id);
    }

    public Member querySlaveById(long id){
        return slaveThirdMemberMapper.queryById(id);
    }

}
