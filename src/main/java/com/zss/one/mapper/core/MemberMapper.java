package com.zss.one.mapper.core;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
