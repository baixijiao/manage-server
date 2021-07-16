package net.bai.server.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("net.bai.server.demo.*.dao")
@ServletComponentScan(basePackages ="net.bai.server.demo.config.druid")
@EnableSwagger2
public class CommonDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonDemoApplication.class, args);
    }

}
