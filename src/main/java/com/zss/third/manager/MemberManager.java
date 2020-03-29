package com.zss.third.manager;

import com.zss.domain.JobTask;
import com.zss.domain.Member;
import com.zss.domain.MemberOrder;
import com.zss.third.mapper.core.MemberMapper;
import com.zss.third.mapper.order.MemberOrderMapper;
import com.zss.third.mapper.schedule.JobTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberManager {

    //core 库
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberOrderMapper coreMemberOrderMapper;

    public Member queryMember(long id){
        return memberMapper.queryById(id);
    }

    public MemberOrder queryCoreOrder(long id){
        return coreMemberOrderMapper.queryById(id);
    }


    //schedule 库
    @Autowired
    private JobTaskMapper jobTaskMapper;

    @Autowired
    private MemberOrderMapper scheduleMemberOrderMapper;

    public JobTask queryJob(long id){
        return jobTaskMapper.queryById(id);
    }

    public MemberOrder queryScheduleOrder(long id){
        return scheduleMemberOrderMapper.queryById(id);
    }
}
