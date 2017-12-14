package sand.config;

public class DbContextHolder {
    public  static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        contextHolder.remove();
    }


    public enum DBTypeEnum {
        one("dataSource_one"),
        two("dataSource_two");
        private String value;

        DBTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
}
