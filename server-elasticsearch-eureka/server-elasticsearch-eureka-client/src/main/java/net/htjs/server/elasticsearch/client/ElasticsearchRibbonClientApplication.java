package net.htjs.server.elasticsearch.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
public class ElasticsearchRibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchRibbonClientApplication.class, args);
    }

}
