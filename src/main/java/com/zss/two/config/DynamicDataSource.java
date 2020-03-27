package com.zss.two.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource implements AutoCloseable{


    static final ThreadLocal<String> dataSourceKeyThreadLocal = new ThreadLocal<>();

    public static String getDataSourceName(){
        String key = dataSourceKeyThreadLocal.get();
        return StringUtils.isBlank(key) ?DataSourceConstants.CORE_DATA_SOURCE:key;
    }

    public DynamicDataSource(String key){
        dataSourceKeyThreadLocal.set(key);
    }

    @Override
    public void close() throws Exception {
        dataSourceKeyThreadLocal.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return  getDataSourceName();
    }
}
