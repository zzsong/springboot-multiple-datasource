package com.zss.two.config;

import org.apache.commons.lang3.StringUtils;

public class DataSourceContextRouting implements AutoCloseable {

    static final ThreadLocal<String> dataSourceKeyThreadLocal = new ThreadLocal<>();

    public static String getDataSourceName(){
        String key = dataSourceKeyThreadLocal.get();
        return StringUtils.isBlank(key) ?DataSourceConstants.MASTER_DATA_SOURCE:key;
    }

    public DataSourceContextRouting(String key){
        dataSourceKeyThreadLocal.set(key);
    }

    @Override
    public void close() throws Exception {
        dataSourceKeyThreadLocal.remove();
    }
}
