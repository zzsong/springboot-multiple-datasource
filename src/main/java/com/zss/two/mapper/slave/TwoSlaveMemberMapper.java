package com.zss.two.mapper.slave;

import com.zss.domain.Member;
import org.apache.ibatis.annotations.Select;


public interface TwoSlaveMemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
