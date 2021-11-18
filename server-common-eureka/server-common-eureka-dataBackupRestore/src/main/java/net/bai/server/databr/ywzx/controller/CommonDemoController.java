package net.bai.server.databr.ywzx.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import net.bai.server.databr.ywzx.service.ICommonDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: baixijiao
 * @Date：2021-01-22 17:19
 * @Description： dataBR项目服务入口
 * @Modified By:
 */
@Api(value = "/commonDemo", tags = "dataBR项目服务入口")
@RestController
@RequestMapping("/commonDemo")
@Slf4j
public class CommonDemoController {

    @Autowired
    ICommonDemoService commonDemoService;

    @GetMapping("/from")
    public String from(@RequestParam(required = false,defaultValue = "commonDemo") String name){
        return commonDemoService.from(name);
    }

    @ApiOperation(value = "根据id获取信息", notes = "根据id获取信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "{\"code\":0,\"title\":\"\",\"message\":\"SUCCESS\",\"data\":[]}")
    })
    @GetMapping("/getData/{id}")
    public Map<String, Object> getData(@PathVariable String id){
        return commonDemoService.getData(id);
    }

}
