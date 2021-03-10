package net.htjs.server.netty.server.config;

import net.htjs.server.netty.server.config.beans.TerminateBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: baixijiao
 * @Date：2021-01-23 09:07
 * @Description： Netty服务端服相关bean配置
 * @Modified By:
 */
@Configuration
public class CommonConfig {

    // 服务停止的bean
    @Bean
    public TerminateBean getTerminateBean() {
        return new TerminateBean();
    }

}
