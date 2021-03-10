package net.htjs.server.dataSources;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(basePackages = "net.htjs.server.dataSources.ywzx.dao")
@EnableCaching
public class CommonDataSourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonDataSourcesApplication.class, args);
    }

}
