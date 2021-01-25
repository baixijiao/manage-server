package net.htjs.server.config.client.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: baixijiao
 * @Date：2021-01-25 10:27
 * @Description： 配置服务客户端的配置信息
 * @Modified By:
 */
@ConfigurationProperties(prefix="config.client.demo")
@Data
public class ConfigClientDemo {

    private String demo;

}
