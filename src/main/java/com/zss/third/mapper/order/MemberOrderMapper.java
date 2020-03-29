package com.zss.third.mapper.order;

import com.zss.domain.MemberOrder;
import org.apache.ibatis.annotations.Select;

public interface MemberOrderMapper {

    @Select("select * from member_order where id = #{id}")
    MemberOrder queryById(long id);
}
