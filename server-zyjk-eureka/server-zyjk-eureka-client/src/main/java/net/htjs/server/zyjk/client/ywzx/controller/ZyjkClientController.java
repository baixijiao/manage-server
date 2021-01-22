package net.htjs.server.zyjk.client.ywzx.controller;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.zyjk.client.ywzx.service.IZyjkClientService;
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
 * @Description： 致远客户端服务入口
 * @Modified By:
 */
@RestController
@RequestMapping("/zyjk")
@Slf4j
public class ZyjkClientController {

    @Autowired
    IZyjkClientService zyjkClientService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "zyjkClient") String name){
        return zyjkClientService.from(name);
    }

    @GetMapping("/fromRibbon")
    public String  fromRibbon() {
        ServiceInstance instance = loadBalancer.choose("eureka-client");
        return instance.getHost()+":"+instance.getPort();
    }

}
