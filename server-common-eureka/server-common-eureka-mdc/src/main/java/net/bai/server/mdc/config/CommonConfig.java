package net.bai.server.mdc.config;

import net.bai.server.mdc.config.beans.TerminateBean;
import net.bai.server.mdc.config.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: baixijiao
 * @Date：2021-01-23 09:07
 * @Description： 多数据源服务相关bean配置
 * @Modified By:
 */
@Configuration
public class CommonConfig {

    // 服务停止的bean
    @Bean
    public TerminateBean getTerminateBean() {
        return new TerminateBean();
    }

    @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }

}
