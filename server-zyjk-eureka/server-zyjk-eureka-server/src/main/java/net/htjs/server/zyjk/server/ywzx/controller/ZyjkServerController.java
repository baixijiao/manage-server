package net.htjs.server.zyjk.server.ywzx.controller;

import lombok.extern.slf4j.Slf4j;
import net.htjs.server.zyjk.server.ywzx.service.IZyjkServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:19
 * @Description： 致远服务端服务入口
 * @Modified By:
 */
@RestController
@RequestMapping("/zyjk")
@Slf4j
public class ZyjkServerController {

    @Autowired
    IZyjkServerService zyjkServerService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "zyjkServer") String name){
        return zyjkServerService.from(name);
    }

}
