package net.htjs.server.dataSources.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Auther: baixijiao
 * @Date：2021-03-08 16:12
 * @Description： MultipleDataSource配置
 * @Modified By:
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> contextHolder = new InheritableThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return this.getDataSource();
    }

    /**
     * 设置数据源
     *
     * @param db
     */
    public static void setDataSource(String db) {
        contextHolder.set(db);
    }

    /**
     * 取得当前数据源
     *
     * @return
     */
    public static String getDataSource() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        contextHolder.remove();
    }
}
