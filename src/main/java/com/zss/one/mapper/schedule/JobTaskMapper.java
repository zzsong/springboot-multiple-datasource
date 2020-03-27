package com.zss.one.mapper.schedule;

import com.zss.domain.JobTask;
import org.apache.ibatis.annotations.Select;

public interface JobTaskMapper {

    @Select("select * from job_task where id = #{id}")
    JobTask queryById(long id);

}
