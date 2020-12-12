package com.zss.two.mapper.master;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface TwoMasterMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
