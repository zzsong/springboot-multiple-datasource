# springboot-multiple-datasource

配置多数据源的方式
one:
    直接使用多@Bean配置，@MapperScan来路径区分读何库
    

two:
    使用注解的方式来标识走何dataSource,AOP拦截注入动态数据源    
