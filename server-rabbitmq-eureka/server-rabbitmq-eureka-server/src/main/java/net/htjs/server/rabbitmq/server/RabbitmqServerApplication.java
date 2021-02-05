package net.htjs.server.rabbitmq.server;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
@EnableSwagger2
public class RabbitmqServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServerApplication.class, args);
    }

}
