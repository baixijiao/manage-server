package net.htjs.server.cache.springboot.config.datasource;

import java.lang.annotation.*;

/**
 * @Auther: baixijiao
 * @Date：2021-03-08 16:09
 * @Description： 定义数据源注解
 * @Modified By:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {
    DataSourceEnum value() default DataSourceEnum.DB1;
}
