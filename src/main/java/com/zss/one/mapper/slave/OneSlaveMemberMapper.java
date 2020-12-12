package com.zss.one.mapper.slave;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface OneSlaveMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
