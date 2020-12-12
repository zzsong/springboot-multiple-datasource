# springboot-multiple-datasource

配置多数据源的方式
one:
    直接使用多@Bean配置，@MapperScan来路径区分读何库
    
two:
    使用注解的方式来标识走何dataSource,AOP拦截注入动态数据源    

third:
    使用spring的Bean命名策略进行区分数据来源

four:
    使用外部传入参数，动态切换数据源，原理与例二相似
    

注意事项：
    多数据源的配置，不使用@EnableConfigurationProperties(MybatisProperties.class)，
    默认加载成单例，导致所有数据源共用一个Configuration,扰乱多数据源的参数设置。    
