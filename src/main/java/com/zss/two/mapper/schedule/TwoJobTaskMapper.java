package com.zss.two.mapper.schedule;

import com.zss.domain.JobTask;
import org.apache.ibatis.annotations.Select;



public interface TwoJobTaskMapper {

    @Select("select * from job_task where id = #{id}")
    JobTask queryById(long id);

}
