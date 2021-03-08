package net.htjs.server.dataSources.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: baixijiao
 * @Date：2021-03-08 16:09
 * @Description： 定义数据源切面
 * @Modified By:
 */
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@within(net.htjs.server.dataSources.config.datasource.DS) || @annotation(net.htjs.server.dataSources.config.datasource.DS)")
    public void pointCut() {

    }

    @Before("pointCut() && @annotation(ds)")
    public void doBefore(DS ds) {
        String value = ds.value().getValue();
        MultipleDataSource.setDataSource(value);
    }

    @After("pointCut()")
    public void doAfter() {
        MultipleDataSource.clear();
    }
}