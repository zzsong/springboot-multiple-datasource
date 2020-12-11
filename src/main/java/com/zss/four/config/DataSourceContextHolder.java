package com.zss.four.config;

import com.zss.two.config.DataSourceConstants;
import org.apache.commons.lang3.StringUtils;

public class DataSourceContextHolder  implements AutoCloseable {

    static final ThreadLocal<String> dataSourceKeyThreadLocal = new ThreadLocal<>();

    public static String getDataSourceName(){
        String key = dataSourceKeyThreadLocal.get();
        return StringUtils.isBlank(key) ? DataSourceConstants.CORE_DATA_SOURCE:key;
    }

    public DataSourceContextHolder(String key){
        dataSourceKeyThreadLocal.set(key);
    }

    @Override
    public void close() throws Exception {
        dataSourceKeyThreadLocal.remove();
    }

}
