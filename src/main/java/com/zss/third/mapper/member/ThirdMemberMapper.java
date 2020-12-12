package com.zss.third.mapper.member;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface ThirdMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
