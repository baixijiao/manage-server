package net.htjs.server.cache.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("net.htjs.server.cache.springboot.*.dao")
@ServletComponentScan(basePackages ="net.htjs.server.cache.springboot.config.druid")
public class CommonCacheSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonCacheSpringbootApplication.class, args);
    }

}
