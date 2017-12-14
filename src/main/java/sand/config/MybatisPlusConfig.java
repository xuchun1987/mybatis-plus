package sand.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan("sand.mapper*")
public class MybatisPlusConfig {

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */

    /* @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
    */

    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "cwbb.datasource.db1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }




    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "cwbb.datasource.db2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "ds3")
    @ConfigurationProperties(prefix = "cwbb.datasource.db3")
    public DataSource dataSource3() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "dataSource")
    @Primary
    public DataSource dynamicDataSource(
            @Qualifier(value ="ds1")DataSource ds1,
            @Qualifier(value ="ds2")DataSource ds2){

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(ds1);
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put("dataSource_one", ds1);
        dsMap.put("dataSource_two", ds2);
        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }


    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory( ResourceLoader resourceLoader) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dynamicDataSource(dataSource1(),dataSource2()));
        sqlSessionFactory.setTypeAliasesPackage("sand.entity");
        //sqlSessionFactory.setConfigLocation(resourceLoader.getResource());//xml路径
        MybatisConfiguration configuration = new MybatisConfiguration();
        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
                paginationInterceptor()
        });
        sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();


    }


    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //paginationInterceptor.setSqlParser();//自定义解析类、可以没有
        paginationInterceptor.setLocalPage(false);// 开启 PageHelper 的支持
        paginationInterceptor.setDialectClazz("mysql");
        //paginationInterceptor.setDialectClazz();//自定义方言类、可以没有
        return paginationInterceptor;
    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        conf.setLogicDeleteValue("-1");
        conf.setLogicNotDeleteValue("1");
        conf.setIdType(2);
        //conf.setMetaObjectHandler(new H2MetaObjectHandler());
        return conf;
    }





}
