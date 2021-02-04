package net.htjs.server.elasticsearch.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
@EnableElasticsearchRepositories
@EnableSwagger2
public class ElasticsearchRibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchRibbonClientApplication.class, args);
    }

}
