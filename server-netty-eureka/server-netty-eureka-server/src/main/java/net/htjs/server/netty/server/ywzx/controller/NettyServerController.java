package net.htjs.server.netty.server.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.htjs.server.netty.server.ywzx.service.INettyServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baixijiao
 * @Date：2021-03-10 15:02
 * @Description： Netty服务端服务入口
 * @Modified By:
 */
@Api(value = "/netty", tags = "Netty服务端服务入口")
@RestController
@RequestMapping("/netty")
@Slf4j
public class NettyServerController {

    @Autowired
    INettyServerService nettyServerService;

    @ApiOperation(value = "服务接口来源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "nettyServer") String name){
        return nettyServerService.from(name);
    }
    
}
