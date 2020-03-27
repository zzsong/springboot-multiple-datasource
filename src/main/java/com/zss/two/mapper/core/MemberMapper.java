package com.zss.two.mapper.core;

import com.zss.domain.Member;
import com.zss.two.config.DataSourceConstants;
import com.zss.two.config.TargetDataSource;
import org.apache.ibatis.annotations.Select;

@TargetDataSource(DataSourceConstants.CORE_DATA_SOURCE)
public interface MemberMapper {

    @Select("select * from member where id = #{id}")
    Member queryById(long id);
}
