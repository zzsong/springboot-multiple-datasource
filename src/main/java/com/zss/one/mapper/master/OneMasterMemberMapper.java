package com.zss.one.mapper.master;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface OneMasterMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
