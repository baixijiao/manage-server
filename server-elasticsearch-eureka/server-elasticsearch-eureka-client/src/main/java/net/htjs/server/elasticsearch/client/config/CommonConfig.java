package net.htjs.server.elasticsearch.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: baixijiao
 * @Date：2021-01-23 17:02
 * @Description： Elasticsearch配置类
 * @Modified By:
 */
@Configuration
public class CommonConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
