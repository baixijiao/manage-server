package net.htjs.server.netty.client.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.htjs.server.netty.client.ywzx.service.INettyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baixijiao
 * @Date：2021-03-10 15:02
 * @Description： Netty客户端服务入口
 * @Modified By:
 */
@Api(value = "/netty", tags = "Netty客户端服务入口")
@RestController
@RequestMapping("/netty")
@Slf4j
public class NettyClientController {

    @Autowired
    INettyClientService nettyClientService;

    @ApiOperation(value = "服务接口来源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/from")
    public String from(@RequestParam(required = false, defaultValue = "nettyClient") String name) {
        return nettyClientService.from(name);
    }
    
}
