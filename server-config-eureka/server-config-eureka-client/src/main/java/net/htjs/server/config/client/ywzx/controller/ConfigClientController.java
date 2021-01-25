package net.htjs.server.config.client.ywzx.controller;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.config.client.ywzx.service.IConfigClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 16:16
 * @Description： 配置客户端服务入口
 * @Modified By:
 */
@RestController
@RequestMapping("/config")
@Slf4j
public class ConfigClientController {

    @Autowired
    IConfigClientService configClientService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "configClient") String name){
        return configClientService.from(name);
    }

    // 从config服务端获取本服务的相关配置
    @GetMapping("/getDemoServerConfig")
    public String getDemoServerConfig(@RequestParam(required = false,defaultValue = "demoServerConfig") String serverConfig){
        return configClientService.getDemoServerConfig(serverConfig);
    }

}
