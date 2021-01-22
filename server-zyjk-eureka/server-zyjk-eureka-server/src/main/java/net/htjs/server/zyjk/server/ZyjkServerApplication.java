package net.htjs.server.zyjk.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZyjkServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyjkServerApplication.class, args);
    }

}
