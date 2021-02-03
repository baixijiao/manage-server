package net.htjs.server.zipkin.demo.ywzx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:20
 * @Description： Demo客户端服务实现类
 * @Modified By:
 */
@Service
@Slf4j
public class DemoClientServicImpl implements IDemoClientService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${demo.serverUrl}")
    private String demoServerUrl;

    @HystrixCommand(fallbackMethod = "fromError")
    @Override
    public String from(String name) {
        String url = demoServerUrl + "demo/from?name=aaa";
        String forObject = restTemplate.getForObject(url + "from?name=aaa", String.class);
        return forObject;
    }

    public String fromError(String name) {
        return "from demoClient server--->>>,"+name+",sorry,error!";
    }
}
