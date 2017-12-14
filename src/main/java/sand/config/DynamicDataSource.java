package sand.config;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource {

    private final Logger logger = Logger.getLogger(getClass());

    /**
     * 取得当前使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("------------当前使用的数据源名称："+DbContextHolder.getDbType());
        return DbContextHolder.getDbType();
    }
}


