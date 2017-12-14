package sand.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sand.config.DbContextHolder;

@Aspect
@Component
@Order(-100)// 保证该AOP在@Transactional之前执行
public class DataSourceAop {

    private Logger logger = LoggerFactory.getLogger(getClass());



    @Before("execution(* sand.service.db1..*.*(..)) ")//*所有返回类型  ..*当前包及下所有子包及所有类 .*所有方法 (..)所有入参
    public void setReadDataSourceType() {
        DbContextHolder.setDbType(DbContextHolder.DBTypeEnum.one);
        logger.info("-----------dataSource切换到："+DbContextHolder.DBTypeEnum.one.getValue());
    }

    @Before("execution(* sand.service.db2..*.*(..)) ")
    public void setWriteDataSourceType() {
        DbContextHolder.setDbType(DbContextHolder.DBTypeEnum.two);
        logger.info("-----------dataSource切换到："+DbContextHolder.DBTypeEnum.two.getValue());
    }

}
