package net.htjs.server.zyjk.client.ywzx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:20
 * @Description： 致远客户端服务实现类
 * @Modified By:
 */
@Service
@Slf4j
public class ZyjkClientServicImpl implements IZyjkClientService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${zyjk.serverUrl}")
    private String zyjkServerUrl;

    @HystrixCommand(fallbackMethod = "fromError")
    @Override
    public String from(String name) {
        String url = zyjkServerUrl + "zyjk/from?name=aaa";
        String forObject = restTemplate.getForObject(url + "from?name=aaa", String.class);
        return forObject;
    }

    public String fromError(String name) {
        return "from zyjkClient server--->>>,"+name+",sorry,error!";
    }
}
