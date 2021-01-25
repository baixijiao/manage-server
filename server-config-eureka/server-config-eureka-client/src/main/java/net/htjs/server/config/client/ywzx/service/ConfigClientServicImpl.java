package net.htjs.server.config.client.ywzx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import net.htjs.server.config.client.config.properties.ConfigClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:20
 * @Description： 配置客户端服务实现类
 * @Modified By:
 */
@Service
@Slf4j
public class ConfigClientServicImpl implements IConfigClientService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;

    @Autowired
    private ConfigClientDemo configClientDemo;

    @HystrixCommand(fallbackMethod = "fromError")
    @Override
    public String from(String name) {
        String url = applicationName + ":from:" + port;
        String forObject = restTemplate.getForObject(url + "from?name=aaa", String.class);
        return forObject;
    }

    public String fromError(String name) {
        return applicationName + " configClient server--->>>,"+name+",sorry,error!";
    }


    @Override
    public String getDemoServerConfig(String serverConfig) {
        return configClientDemo.toString();
    }
}
