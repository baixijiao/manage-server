package net.htjs.server.config.client;

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
public class ConfigRibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigRibbonClientApplication.class, args);
    }

}
