package com.zss.four.mapper.core;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface FourMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
