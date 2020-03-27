package com.zss.two.mapper.schedule;

import com.zss.domain.JobTask;
import com.zss.two.config.DataSourceConstants;
import com.zss.two.config.TargetDataSource;
import org.apache.ibatis.annotations.Select;


@TargetDataSource(DataSourceConstants.SCHEDULE_DATA_SOURCE)
public interface JobTaskMapper {

    @Select("select * from job_task where id = #{id}")
    JobTask queryById(long id);

}
