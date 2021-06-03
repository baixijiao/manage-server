package net.htjs.server.cache.springboot.config.datasource;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: baixijiao
 * @Date：2021-03-08 16:07
 * @Description： 定义数据源枚举
 * @Modified By:
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DataSourceEnum {

    DB1("db1"),
    DB2("db2");

    private String value;

}