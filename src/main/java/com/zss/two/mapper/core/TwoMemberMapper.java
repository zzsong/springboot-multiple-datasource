package com.zss.two.mapper.core;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface TwoMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
